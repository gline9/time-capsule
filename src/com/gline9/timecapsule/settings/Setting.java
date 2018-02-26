package com.gline9.timecapsule.settings;

import java.util.Set;

import org.bson.types.ObjectId;

import com.gline9.timecapsule.models.Field;
import com.gline9.timecapsule.models.Key;
import com.gline9.timecapsule.models.Model;

public class Setting<V> extends Model<Setting<?>>
{

    private static final Field<Setting<?>, ObjectId> ID = new Field<>(ObjectId.class, Key.ID);
    private static final Field<Setting<?>, String> KEY = new Field<>(String.class, Key.KEY);
    private final Field<Setting<?>, V> VALUE;

    public Setting(String key, Class<V> clazz)
    {
        VALUE = new Field<Setting<?>, V>(clazz, Key.VALUE);
        set(KEY, key);
    }

    @Override
    public Set<Field<Setting<?>, ?>> getFields()
    {
        return Set.of(ID, KEY, VALUE);
    }
    
    @Override
    public Field<Setting<?>, ?> getIDField()
    {
        return ID;
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
