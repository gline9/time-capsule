package com.gline9.timecapsule;

import com.gline9.timecapsule.database.Collections;
import com.gline9.timecapsule.message.Message;

public class ProgramStart
{

    public static void main(String[] args)
    {
        Message m = new Message();
        m.set(Message.MESSAGE, "hello world");
        Collections.MESSAGES.insert(m);
    }
}
