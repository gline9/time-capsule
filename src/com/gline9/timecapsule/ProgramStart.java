package com.gline9.timecapsule;

import java.time.Instant;

import com.gline9.timecapsule.message.Message;
import com.gline9.timecapsule.settings.Setting;

public class ProgramStart
{

    public static void main(String[] args)
    {
        Setting<Integer> intSetting = new Setting<>("int", Integer.class);
        intSetting.setValue(5);
        System.out.println(intSetting);
        System.out.println(intSetting.getValue());
        System.out.println(intSetting.toDocument());
        Message m = new Message();
        m.set(Message.MESSAGE, "test");
        m.set(Message.CREATED_TIME, Instant.now());
        System.out.println(m.toDocument());
        Setting<Instant> instantSetting = new Setting<>("instant", Instant.class);
        instantSetting.setValue(Instant.now());
        System.out.println(instantSetting.toDocument());
    }
}
