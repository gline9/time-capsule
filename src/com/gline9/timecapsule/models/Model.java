package com.gline9.timecapsule.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.bson.Document;

public abstract class Model<M extends Model<M>>
{
    
    private final Supplier<? extends M> constructor;
    
    public Model(Supplier<? extends M> constructor)
    {
        this.constructor = constructor;
    }

    public final Map<Field<M, ?>, Object> data = new HashMap<>();

    public abstract Set<Field<M, ?>> getFields();

    public <V> void set(Field<M, V> field, V value)
    {
        data.put(field, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(Field<M, V> field)
    {
        return (V) data.get(field);
    }
    
    public Document toDocument()
    {
        Document ret = new Document();
        
        for (Field<M, ?> field : getFields())
        {
            Object value = data.get(field);
            Object transformed = CodecRegistry.encode(field, value);
            if (null != transformed)
            {
                ret.append(field.getKey(), transformed);
            }
        }
        return ret;
    }
    
    public M parse(Document doc)
    {
        M res = this.constructor.get();

        for (Field<M, ?> field : getFields())
        {
            if (!doc.containsKey(field.getKey()))
            {
                continue;
            }
            
            Object value = doc.get(field.getKey());
            data.put(field, CodecRegistry.decode(field, value));
        }
        
        return res;
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
