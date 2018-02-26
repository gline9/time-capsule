package com.gline9.timecapsule.database;

import java.util.function.Supplier;

import org.bson.Document;

import com.gline9.timecapsule.models.Model;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;

public class Collection<M extends Model<M>>
{
    private final String collectionName;
    private final Supplier<M> constructor;
    public Collection(String name, Supplier<M> constructor)
    {
        collectionName = name;
        this.constructor = constructor;
    }

    
    private MongoCollection<Document> collection = null;
    private MongoCollection<Document> get()
    {
        if (null == collection)
        {
            collection = Database.getDatabase().getCollection(collectionName);
        }
        
        return collection;
    }
    
    public void insert(M value)
    {
        get().insertOne(value.toDocument());
    }
    
    public M find(M value)
    {
        return safeParse(get().find(value.toMatchDocument()).first());
    }
    
    public void delete(M value)
    {
        get().deleteOne(value.toMatchDocument());
    }
    
    public void update(M value)
    {
        update(value, false);
    }
    
    public void upsert(M value)
    {
        update(value, true);
    }
    
    public void update(M value, boolean upsert)
    {
        get().updateOne(value.toMatchDocument(), value.toUpdateDocument(), new UpdateOptions().upsert(upsert));
    }
    
    public M safeParse(Document doc)
    {
        if (null == doc)
        {
            return null;
        }
        M ret = constructor.get();
        ret.populate(doc);
        return ret;
    }
    
    
}
