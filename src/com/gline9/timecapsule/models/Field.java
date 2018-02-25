package com.gline9.timecapsule.models;

public class Field<M extends Model<M>, V>
{

    private final String key;
    private final Class<V> clazz;

    public Field(Class<V> clazz, String key)
    {
        this.key = key;
        this.clazz = clazz;
    }

    public String getKey()
    {
        return key;
    }
    
    public Class<V> getValueClass()
    {
        return clazz;
    }
}
