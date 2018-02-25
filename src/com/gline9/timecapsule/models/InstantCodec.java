package com.gline9.timecapsule.models;

import java.time.Instant;

public class InstantCodec implements Codec<Instant>
{

    @Override
    public Object encode(Instant value)
    {
        return value.toEpochMilli();
    }

    @Override
    public Instant decode(Object object)
    {
        if (!(object instanceof Long))
        {
            throw new IllegalStateException("Instant codec expectes Number");
        }
        return Instant.ofEpochMilli((Long)object);
    }
    
    static
    {
    }
    
}
