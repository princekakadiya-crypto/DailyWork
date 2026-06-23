package com.tss.solution.test;

import com.tss.solution.model.*;

public class BirdTest {
    public static void main(String[] args) {
        Penguin bird1=new Penguin();
        Sparrow bird2=new Sparrow();

        FlyingBirdClient flyingBirdClient=new FlyingBirdClient();
        flyingBirdClient.makeBirdFly(bird2);

        BirdClient birdClient=new BirdClient();
        birdClient.feedBird(bird1);
        birdClient.feedBird(bird2);
    }
}
