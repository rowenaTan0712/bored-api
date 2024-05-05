package com.bored.service;

import com.bored.model.dto.BoredDTO;
import com.bored.util.BoredException;

public interface BoredService {

    public BoredDTO getRandomActivity() throws BoredException;
    public BoredDTO getActivityByType(String type) throws BoredException;
    public BoredDTO getActivityByParticipants(int numOfPerson) throws BoredException;
}
