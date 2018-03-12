package com.gline9.timecapsule.database;

import java.util.function.Function;
import java.util.function.Supplier;

import org.bson.Document;

import com.gline9.timecapsule.models.Model;
import com.gline9.timecapsule.models.Modelable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;

public class Repository<T extends Model<T>, M extends Modelable<T>>
{
    private final String collectionName;
    private final Function<T, M> constructor;
    private final Supplier<T> supplier;
    public Repository(String name, Function<T, M> constructor, Supplier<T> supplier)
    {
        collectionName = name;
        this.constructor = constructor;
        this.supplier = supplier;
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
        get().insertOne(value.getModel().toDocument());
    }
    
    public M find(M value)
    {
        return safeParse(get().find(value.getModel().toMatchDocument()).first());
    }
    
    public void delete(M value)
    {
        get().deleteOne(value.getModel().toMatchDocument());
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
        get().updateOne(value.getModel().toMatchDocument(), value.getModel().toUpdateDocument(), new UpdateOptions().upsert(upsert));
    }
    
    public M safeParse(Document doc)
    {
        if (null == doc)
        {
            return null;
        }
        T val = supplier.get();
        val.populate(doc);
        return constructor.apply(val);
    }
    
    
}
