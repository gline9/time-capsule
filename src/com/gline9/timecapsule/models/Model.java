package com.gline9.timecapsule.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.bson.Document;

public abstract class Model<M extends Model<M>>
{
    
    public final Map<Field<M, ?>, Object> data = new HashMap<>();

    public abstract Set<Field<M, ?>> getFields();
    
    public abstract Field<M, ?> getIDField();

    public <V> void set(Field<M, V> field, V value)
    {
        data.put(field, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(Field<M, V> field)
    {
        return (V) data.get(field);
    }
    
    public Document toMatchDocument()
    {
        Field<M, ?> id = getIDField();
        String key = Key.MONGO_ID;
        Object value = data.get(id);
        Object transformed = CodecRegistry.encode(id, value);
        if (null == transformed)
        {
            throw new NullPointerException("ID of a model can't be null if a find is being performed");
        }
        return new Document(key, transformed);
    }
    
    public Document toUpdateDocument()
    {
        Document ret = toDocument();
        
        if (ret.containsKey(Key.MONGO_ID))
        {
            ret.remove(Key.MONGO_ID);
        }
        
        return new Document("$set", ret);
    }
    
    public Document toDocument()
    {
        Document ret = new Document();
        
        for (Field<M, ?> field : getFields())
        {
            String key = field.getKey();
            if (field == getIDField())
            {
                key = Key.MONGO_ID;
            }
            Object value = data.get(field);
            Object transformed = CodecRegistry.encode(field, value);
            if (null != transformed)
            {
                ret.append(key, transformed);
            }
        }
        return ret;
    }
    
    public void populate(Document doc)
    {
        for (Field<M, ?> field : getFields())
        {
            String key = field.getKey();
            if (field == getIDField())
            {
                key = Key.MONGO_ID;
            }

            if (!doc.containsKey(key))
            {
                continue;
            }
            
            
            Object value = doc.get(key);
            data.put(field, CodecRegistry.decode(field, value));
        }
    }
    

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field<M, ?> field : getFields())
        {
            Object value = data.get(field);
            sb.append(field.getKey() + " = \"" + String.valueOf(value) + "\", ");
        }
        // delete last comma
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

}
