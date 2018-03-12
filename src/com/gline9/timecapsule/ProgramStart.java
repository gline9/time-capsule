package com.gline9.timecapsule;

import com.gline9.timecapsule.message.Message;

public class ProgramStart
{

    public static void main(String[] args)
    {
        Message message = Message.insertNewMessage("hello world");
        Message found = Message.REPO.find(message);
        System.out.println(found.getMessage());
    }
}
