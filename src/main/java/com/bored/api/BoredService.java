package com.bored.api;

public interface BoredLayer {

    public Bored getRandomActivity();
    public Bored getActivityByType(String type);
    public Bored getActivityByParticipants(int numOfPerson);
}
