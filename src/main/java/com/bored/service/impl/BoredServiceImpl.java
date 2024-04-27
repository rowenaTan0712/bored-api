package com.bored.service.impl;

import com.bored.model.dto.ActivityDTO;
import com.bored.model.dto.response.BoredResponse;
import com.bored.model.dto.BoredDTO;
import com.bored.service.BoredService;
import com.bored.util.BoredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class BoredServiceImpl implements BoredService {

    @Autowired
    private final RestTemplate restTemplate;
    @Value("${bored-source.api.base}")
    private String boredBaseUrl;

    public BoredServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public BoredDTO getRandomActivity() throws BoredException {
        BoredDTO boredDTO = new BoredDTO();
        String randomEndpoint = boredBaseUrl + "/activity/";

        try{
            ResponseEntity<BoredResponse> boredResp = restTemplate.getForEntity(randomEndpoint, BoredResponse.class);
            if(boredResp.getStatusCode() == HttpStatus.OK){
                ActivityDTO activity = new ActivityDTO();
                activity.setActivityName(boredResp.getBody().getActivity());
                activity.setLink(boredResp.getBody().getLink());
                activity.setActivityType(boredResp.getBody().getType());
                activity.setPrice(boredResp.getBody().getPrice());
                activity.setParticipantNumber(boredResp.getBody().getParticipants());

                boredDTO.setMessage("Success");
                boredDTO.setActivity(activity);
            }else{
                if(boredResp.getStatusCode() == HttpStatus.BAD_REQUEST){
                    boredDTO.setMessage("Invalid Parameter");
                }else{
                    boredDTO.setMessage("Internal Server Error");
                }
            }
        }catch(HttpClientErrorException ex){
            throw new BoredException(ex.getMessage());
        }catch(Exception ex){
            throw new BoredException(ex.getMessage());
        }

        return boredDTO;
    }

    @Override
    public BoredDTO getActivityByType(String type) throws BoredException {
        BoredDTO boredDTO = new BoredDTO();
        String typeLowerCase = type.toLowerCase();
        String byTypeEndpoint = boredBaseUrl + "/activity?type="+typeLowerCase;

        try{
            ResponseEntity<BoredResponse> boredResp = restTemplate.getForEntity(byTypeEndpoint, BoredResponse.class);
            if(boredResp.getStatusCode() == HttpStatus.OK){
                if(boredResp.getBody().getActivity() != null){
                    ActivityDTO activity = new ActivityDTO();
                    activity.setActivityName(boredResp.getBody().getActivity());
                    activity.setLink(boredResp.getBody().getLink());
                    activity.setActivityType(boredResp.getBody().getType());
                    activity.setPrice(boredResp.getBody().getPrice());
                    activity.setParticipantNumber(boredResp.getBody().getParticipants());

                    boredDTO.setMessage("Success");
                    boredDTO.setActivity(activity);
                }else{
                    boredDTO.setMessage("No activity found with the specified parameters");
                }
            }else{
                if(boredResp.getStatusCode() == HttpStatus.BAD_REQUEST){
                    boredDTO.setMessage("Invalid Parameter");
                }else{
                    boredDTO.setMessage("Internal Server Error");
                }
            }
        }catch(HttpClientErrorException ex){
            throw new BoredException(ex.getMessage());
        }catch(Exception ex){
            throw new BoredException(ex.getMessage());
        }

        return boredDTO;
    }

    @Override
    public BoredDTO getActivityByParticipants(int participants) throws BoredException {
        BoredDTO boredDTO = new BoredDTO();
        String byParticipantEndpoint = boredBaseUrl + "/activity?participants="+participants;
        if(participants > 5){
            boredDTO.setMessage("No activity found with the specified parameters");
            return boredDTO;
        }

        try{
            ResponseEntity<BoredResponse> boredResp = restTemplate.getForEntity(byParticipantEndpoint, BoredResponse.class);
            if(boredResp.getStatusCode() == HttpStatus.OK){
                ActivityDTO activity = new ActivityDTO();
                activity.setActivityName(boredResp.getBody().getActivity());
                activity.setLink(boredResp.getBody().getLink());
                activity.setActivityType(boredResp.getBody().getType());
                activity.setPrice(boredResp.getBody().getPrice());
                activity.setParticipantNumber(boredResp.getBody().getParticipants());

                boredDTO.setMessage("Success");
                boredDTO.setActivity(activity);
            }else{
                if(boredResp.getStatusCode() == HttpStatus.BAD_REQUEST){
                    boredDTO.setMessage("Invalid Parameter");
                }else{
                    boredDTO.setMessage("Internal Server Error");
                }
            }
        }catch(HttpClientErrorException ex){
            throw new BoredException(ex.getMessage());
        }catch(Exception ex){
            throw new BoredException(ex.getMessage());
        }

        return boredDTO;
    }
}
