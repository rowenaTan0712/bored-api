package com.bored.api;

public interface BoredService {

    public BoredWrapper getRandomActivity();
    public BoredWrapper getActivityByType(String type);
    public BoredWrapper getActivityByParticipants(int numOfPerson);
}
