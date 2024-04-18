package com.bored.service;

import com.bored.model.dto.response.BoredResponse;

public interface BoredService {

    public BoredResponse getRandomActivity();
    public BoredResponse getActivityByType(String type);
    public BoredResponse getActivityByParticipants(int numOfPerson);
}
