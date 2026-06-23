package com.tss.tasks;

public class increase{

    private static int count;

    public increase(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        count++;
    }

    public int getCount()
    {
        return count;
    }
}
