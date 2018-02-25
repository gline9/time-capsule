package com.gline9.timecapsule.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Model<M extends Model<M>>
{

    public final Map<Field<M, ?>, Object> data = new HashMap<>();

    public abstract Set<Field<M, ?>> getFields();

    public <V> void set(Field<M, V> field, V value)
    {
        data.put(field, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(Field<M, V> field)
    {
        return (V) data.get(field);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field<M, ?> field : getFields())
        {
            Object value = data.get(field);
            sb.append(field.getKey() + " = \"" + String.valueOf(value) + "\", ");
        }
        // delete last comma
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

}
