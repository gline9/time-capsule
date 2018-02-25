package com.gline9.timecapsule.message;

import java.time.Instant;

public class Message
{
    
    // TODO temporary until changes to model structure
    private String message = null;
    private Instant createdTime = null;
    
    public Message() {}
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String value)
    {
        message = value;
    }
    
    public Instant getCreatedTime()
    {
        return createdTime;
    }
    
    public void setCreeatedTime(Instant value)
    {
        createdTime = value;
    }
}
