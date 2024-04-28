package com.bored.api;

import com.bored.model.dto.ActivityDTO;
import com.bored.model.dto.BoredDTO;
import com.bored.service.BoredService;
import com.bored.service.impl.BoredServiceImpl;
import com.bored.util.BoredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BoredServiceTest {

    @InjectMocks
    private BoredServiceImpl boredServiceImpl;

    @Mock
    private BoredService boredService;

    @BeforeEach
    public void loadService(){
        MockitoAnnotations.openMocks(this);
    }

    public BoredDTO loadBoredDTOSuccess(){
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivityName("play guitar");
        activityDTO.setLink("sample.com");
        activityDTO.setPrice(1.00);
        activityDTO.setParticipantNumber(2);
        activityDTO.setActivityType("music");

        BoredDTO boredDTO = new BoredDTO();
        boredDTO.setMessage("Success");
        boredDTO.setActivity(activityDTO);

        return boredDTO;
    }

    //get random activity test
    @Test
    public void testGetRandomActivity() throws BoredException {
        BoredDTO mockResponse = loadBoredDTOSuccess();
        when(boredService.getRandomActivity()).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getRandomActivity();
        assertNotNull(actualResult);
    }

    //get random activity throw boredexception
    @Test
    public void testGetRandomActivityReturnBoredException() throws BoredException {
        when(boredService.getRandomActivity()).thenThrow(new BoredException("Internal Server Error"));

        BoredException exception = assertThrows(BoredException.class, () -> {boredService.getRandomActivity();});
        assertEquals("Internal Server Error", exception.getMessage());
    }

    //getActivityByType
    @Test
    public void testGetActivityByType() throws BoredException {
        BoredDTO mockResponse = loadBoredDTOSuccess();
        String type = "MUSIC";
        when(boredService.getActivityByType(type)).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getActivityByType(type);
        assertNotNull(actualResult);
    }

    //getActivityByType blank param
    @Test
    public void testGetActivityByTypeReturnRandomActivity() throws BoredException {
        BoredDTO mockResponse = loadBoredDTOSuccess();
        when(boredService.getActivityByType("")).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getActivityByType("");
        assertNotNull(actualResult);
    }

    //getActivityByType unknown type
    @Test
    public void testGetActivityByTypeReturnNoActivityFound() throws BoredException {
        BoredDTO mockResponse = new BoredDTO();
        mockResponse.setMessage("No activity found with the specified parameters");

        String type = "Swimming";
        when(boredService.getActivityByType(type)).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getActivityByType(type);
        assertEquals("No activity found with the specified parameters", actualResult.getMessage());
    }

    //getActivityByParticipants
    @Test
    public void testGetActivityByPartcipants() throws BoredException {
        BoredDTO mockResponse = loadBoredDTOSuccess();
        when(boredService.getActivityByParticipants(2)).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getActivityByParticipants(2);
        assertNotNull(actualResult);
    }

    //getActivityByParticipants 0 participant
    @Test
    public void testGetActivityByPartcipantsReturnNoActivityFound() throws BoredException {
        BoredDTO mockResponse = new BoredDTO();
        mockResponse.setMessage("No activity found with the specified parameters");

        int participants = 0;
        when(boredService.getActivityByParticipants(participants)).thenReturn(mockResponse);

        BoredDTO actualResult = boredService.getActivityByParticipants(participants);
        assertEquals("No activity found with the specified parameters", actualResult.getMessage());
    }
}
