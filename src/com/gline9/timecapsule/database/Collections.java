package com.gline9.timecapsule.database;

import com.gline9.timecapsule.message.Message;

public final class Collections
{

    private Collections() {}
    
    public static final Collection<Message> MESSAGES = new Collection<>("messages", new Message());
}
