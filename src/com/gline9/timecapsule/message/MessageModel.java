package com.gline9.timecapsule.message;

import java.time.Instant;
import java.util.Set;

import org.bson.types.ObjectId;

import com.gline9.timecapsule.models.Field;
import com.gline9.timecapsule.models.Key;
import com.gline9.timecapsule.models.Model;

public class MessageModel extends Model<MessageModel>
{
    
    public static final Field<MessageModel, ObjectId> ID = new Field<>(ObjectId.class, Key.ID);
    public static final Field<MessageModel, String> MESSAGE = new Field<>(String.class, Key.MESSAGE);
    public static final Field<MessageModel, Instant> CREATED_TIME = new Field<>(Instant.class, Key.CREATED_TIME);

    public Set<Field<MessageModel, ?>> getFields()
    {
        return Set.of(ID, MESSAGE, CREATED_TIME);
    }

    @Override
    public Field<MessageModel, ?> getIDField()
    {
        return ID;
    }
}
