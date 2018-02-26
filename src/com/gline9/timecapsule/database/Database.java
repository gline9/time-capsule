package com.gline9.timecapsule.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public final class Database
{
    
    private Database() {}

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
    protected static MongoDatabase getDatabase()
    {
        if (null == database)
        {
            database = getClient().getDatabase("timecapsule");
        }
        
        return database;
    }
}
