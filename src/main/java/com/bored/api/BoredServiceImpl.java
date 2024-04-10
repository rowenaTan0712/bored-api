package com.bored.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoredService implements BoredLayer {

    @Autowired
    private final RestTemplate restTemplate;
    @Value("${bored.api.base}")
    private String boredBaseUrl;

    public BoredService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Bored getRandomActivity(){
        String randomEndpoint = boredBaseUrl + "/activity/";
        return restTemplate.getForObject(randomEndpoint, Bored.class);
    }

    @Override
    public Bored getActivityByType(String type){
        String byTypeEndpoint = boredBaseUrl + "/activity?type="+type;
        return restTemplate.getForObject(byTypeEndpoint, Bored.class);
    }

    @Override
    public Bored getActivityByParticipants(int numOfPerson){
        String byParticipantEndpoint = boredBaseUrl + "/activity?participants="+numOfPerson;
        return restTemplate.getForObject(byParticipantEndpoint, Bored.class);
    }
}
