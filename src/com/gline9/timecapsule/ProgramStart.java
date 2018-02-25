package com.gline9.timecapsule;

import java.time.Instant;

import com.gline9.timecapsule.message.Message;

public class ProgramStart
{

    public static void main(String[] args)
    {
        Message m = new Message();
        m.set(Message.MESSAGE, "hello");
        m.set(Message.CREATED_TIME, Instant.now());
        System.out.println(m);
    }
}
