package com.tss.behavioural.command.model;

public class TurnOnTvCommand implements Command{
    private TV tv;

    public TurnOnTvCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
