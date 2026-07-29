package com.tss.behavioural.command.model;

public class TurnOffTvCommand implements Command {
    private TV tv;

    public TurnOffTvCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
