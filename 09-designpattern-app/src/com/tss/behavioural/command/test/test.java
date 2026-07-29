package com.tss.behavioural.command.test;

import com.tss.behavioural.command.model.*;

public class test {
    public static void main(String[] args) {
        TV tv=new TV();
        Command command=new TurnOffTvCommand(tv);

        RemoteControl remoteControl=new RemoteControl(command);
        remoteControl.pressButton();

        command=new TurnOnTvCommand(tv);

        remoteControl.setCommand(command);
        remoteControl.pressButton();

    }
}
