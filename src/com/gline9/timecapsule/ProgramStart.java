package com.gline9.timecapsule;

import com.gline9.timecapsule.settings.Setting;

public class ProgramStart
{

    public static void main(String[] args)
    {
        Setting<Integer> intSetting = new Setting<>("int");
        intSetting.setValue(5);
        System.out.println(intSetting);
        System.out.println(intSetting.getValue());
    }
}
