package com.gline9.timecapsule.models;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CodecRegistry
{

    private static final Map<Class<?>, Codec<?>> registry = new HashMap<>();

    public static <V> void register(Class<V> clazz, Codec<V> codec)
    {
        registry.put(clazz, codec);
    }

    @SuppressWarnings("unchecked")
    private static <V> Codec<V> getCodec(Class<V> clazz)
    {
        return (Codec<V>) registry.get(clazz);
    }
    
    public static <V> Object encode(Field<?, V> field, Object value)
    {
        Codec<V> codec = getCodec(field.getValueClass());
        if (null == codec)
        {
            return value;
        }
        @SuppressWarnings("unchecked")
        Object encoded = codec.encode((V) value);
        return encoded;
    }
    
    static
    {
        CodecRegistry.register(Instant.class, new InstantCodec());
    }
}
