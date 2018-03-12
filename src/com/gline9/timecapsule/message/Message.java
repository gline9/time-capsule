package com.gline9.timecapsule.message;

import java.time.Instant;

import org.bson.types.ObjectId;

import com.gline9.timecapsule.database.Repository;
import com.gline9.timecapsule.models.Modelable;

public class Message implements Modelable<MessageModel>
{
    private final MessageModel model;
    public static final Repository<MessageModel, Message> REPO = new Repository<>("messages", Message::new, MessageModel::new);

    private Message(String message)
    {
        model = new MessageModel();
        model.set(MessageModel.MESSAGE, message);
        model.set(MessageModel.CREATED_TIME, Instant.now());
        model.set(MessageModel.ID, new ObjectId());
    }
    
    private Message(MessageModel model)
    {
        this.model = model;
    }
    
    public static Message insertNewMessage(String message)
    {
        Message newMessage = new Message(message);
        REPO.insert(newMessage);
        return newMessage;
    }
    
    public MessageModel getModel()
    {
        return model;
    }
    
    public String getMessage()
    {
        return model.get(MessageModel.MESSAGE);
    }
    
}
