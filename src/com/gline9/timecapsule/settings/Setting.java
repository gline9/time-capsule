package com.gline9.timecapsule.settings;

import java.util.Set;

import com.gline9.timecapsule.models.Field;
import com.gline9.timecapsule.models.Key;
import com.gline9.timecapsule.models.Model;

public class Setting<V> extends Model<Setting<?>>
{

    private static final Field<Setting<?>, String> KEY = new Field<>(Key.KEY);
    private final Field<Setting<?>, V> VALUE = new Field<>(Key.VALUE);

    public Setting(String key)
    {
        set(KEY, key);
    }

    @Override
    public Set<Field<Setting<?>, ?>> getFields()
    {
        return Set.of(KEY, VALUE);
    }

    public V getValue()
    {
        return get(VALUE);
    }
    
    public void setValue(V value)
    {
        set(VALUE, value);
    }

}
