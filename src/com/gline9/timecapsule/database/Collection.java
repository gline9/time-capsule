package com.gline9.timecapsule.database;

import java.util.function.Supplier;

import org.bson.Document;

import com.gline9.timecapsule.models.Model;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Collection<M extends Model<M>>
{
    private final String collectionName;
    private final Supplier<M> constructor;
    public Collection(String name, Supplier<M> constructor)
    {
        collectionName = name;
        this.constructor = constructor;
    }

    // TODO make configurable
    private static MongoClient client = null;
    private static MongoClient getClient()
    {
        if (null == client)
        {
            client = new MongoClient("localhost", 27017);
        }
        return client;
    }
    
    private static MongoDatabase database = null;
    private static MongoDatabase getDatabase()
    {
        if (null == database)
        {
            database = getClient().getDatabase("timecapsule");
        }
        
        return database;
    }
    
    private MongoCollection<Document> collection = null;
    private MongoCollection<Document> get()
    {
        if (null == collection)
        {
            collection = getDatabase().getCollection(collectionName);
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
