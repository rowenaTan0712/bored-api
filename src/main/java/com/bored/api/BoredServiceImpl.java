package com.bored.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoredServiceImpl implements BoredService {

    @Autowired
    private final RestTemplate restTemplate;
    @Value("${bored.api.base}")
    private String boredBaseUrl;

    public BoredServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public BoredWrapper getRandomActivity(){
        String randomEndpoint = boredBaseUrl + "/activity/";
        BoredResponse bored = restTemplate.getForObject(randomEndpoint, BoredResponse.class);

        BoredWrapper boredWrap = new BoredWrapper();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }

    @Override
    public BoredWrapper getActivityByType(String type){
        String byTypeEndpoint = boredBaseUrl + "/activity?type="+type;
        BoredResponse bored = restTemplate.getForObject(byTypeEndpoint, BoredResponse.class);

        BoredWrapper boredWrap = new BoredWrapper();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }

    @Override
    public BoredWrapper getActivityByParticipants(int numOfPerson){
        String byParticipantEndpoint = boredBaseUrl + "/activity?participants="+numOfPerson;
        BoredResponse bored = restTemplate.getForObject(byParticipantEndpoint, BoredResponse.class);

        BoredWrapper boredWrap = new BoredWrapper();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }
}
