package com.gline9.timecapsule.message;

import java.time.Instant;
import java.util.Set;

import org.bson.types.ObjectId;

import com.gline9.timecapsule.models.Field;
import com.gline9.timecapsule.models.Key;
import com.gline9.timecapsule.models.Model;

public class Message extends Model<Message>
{

    public static final Field<Message, ObjectId> ID = new Field<>(ObjectId.class, Key.ID);
    public static final Field<Message, String> MESSAGE = new Field<>(String.class, Key.MESSAGE);
    public static final Field<Message, Instant> CREATED_TIME = new Field<>(Instant.class, Key.CREATED_TIME);

    public Set<Field<Message, ?>> getFields()
    {
        return Set.of(ID, MESSAGE, CREATED_TIME);
    }

    @Override
    public Field<Message, ?> getIDField()
    {
        return ID;
    }
}
