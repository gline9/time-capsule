package com.gline9.timecapsule;

import java.time.Instant;

import org.bson.types.ObjectId;

import com.gline9.timecapsule.database.Collections;
import com.gline9.timecapsule.message.Message;

public class ProgramStart
{

    public static void main(String[] args)
    {
        ObjectId id = new ObjectId();
        Message m = new Message();
        m.set(Message.MESSAGE, "hello world");
        m.set(Message.CREATED_TIME, Instant.now());
        m.set(Message.ID, id);
        Collections.MESSAGES.insert(m);
        Message query = new Message();
        query.set(Message.ID, id);
        Message found = Collections.MESSAGES.find(query);
        System.out.println(found);
    }
}
