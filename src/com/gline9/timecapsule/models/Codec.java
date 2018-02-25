package com.gline9.timecapsule.models;


public interface Codec<V>
{
    public Object encode(V value);
    
    public V decode(Object object);
}
