package com.gline9.timecapsule.models;


public class Field<M extends Model<M>, V>
{
    private final String key;
    
    public Field(String key)
    {
        this.key = key;
    }
    
    public String getKey()
    {
        return key;
    }
}
