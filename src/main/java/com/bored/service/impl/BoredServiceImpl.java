package com.bored.service.impl;

import com.bored.model.dto.response.BoredResponse;
import com.bored.model.dto.BoredDAO;
import com.bored.service.BoredService;
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
    public BoredResponse getRandomActivity(){
        String randomEndpoint = boredBaseUrl + "/activity/";
        BoredDAO bored = restTemplate.getForObject(randomEndpoint, BoredDAO.class);

        BoredResponse boredWrap = new BoredResponse();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }

    @Override
    public BoredResponse getActivityByType(String type){
        String byTypeEndpoint = boredBaseUrl + "/activity?type="+type;
        BoredDAO bored = restTemplate.getForObject(byTypeEndpoint, BoredDAO.class);

        BoredResponse boredWrap = new BoredResponse();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }

    @Override
    public BoredResponse getActivityByParticipants(int numOfPerson){
        String byParticipantEndpoint = boredBaseUrl + "/activity?participants="+numOfPerson;
        BoredDAO bored = restTemplate.getForObject(byParticipantEndpoint, BoredDAO.class);

        BoredResponse boredWrap = new BoredResponse();
        boredWrap.setActivityName(bored.getActivity());
        boredWrap.setLink(bored.getLink());
        boredWrap.setActivityType(bored.getType());
        boredWrap.setPrice(bored.getPrice());
        boredWrap.setParticipantNumber(bored.getParticipants());

        return boredWrap;
    }
}
