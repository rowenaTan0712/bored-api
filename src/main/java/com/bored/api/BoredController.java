package com.bored.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoredController {

    private final BoredService boredService;

    public BoredController(BoredService boredService){
        this.boredService = boredService;
    }

    @GetMapping("${bored.project.base}")
    public ResponseEntity<BoredWrapper> randomAPI(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(boredService.getRandomActivity());
    }

    @GetMapping("${bored.project.base}" + "${bored.project.fetch}" + "/activity/{type}")
    public ResponseEntity<BoredWrapper> getByTypeAPI(@PathVariable String type){
        return ResponseEntity.status(HttpStatus.OK)
                .body(boredService.getActivityByType(type));
    }

    @GetMapping("${bored.project.base}" + "${bored.project.fetch}" + "/in-group")
    public ResponseEntity<Object> getByNumberOfParticipants(@RequestParam("number of participants") int number){
        if(number > 5){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No activities available for more than 5 participants");
        }else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(boredService.getActivityByParticipants(number));
        }
    }
}
