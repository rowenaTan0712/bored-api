package com.bored.controller;

import com.bored.service.BoredService;
import com.bored.model.dto.BoredDTO;
import com.bored.util.BoredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoredController {

    @Autowired
    private final BoredService boredService;

    public BoredController(BoredService boredService){
        this.boredService = boredService;
    }

    @GetMapping("${bored.project.base}")
    public ResponseEntity<BoredDTO> randomAPI() throws BoredException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(boredService.getRandomActivity());
    }

    @GetMapping("${bored.project.base}"+"/type"+"/{type}")
    public ResponseEntity<BoredDTO> getByType(@PathVariable String type) throws BoredException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(boredService.getActivityByType(type));
    }

    @GetMapping("${bored.project.base}"+"/group")
    public ResponseEntity<BoredDTO> getByNumberOfParticipants(@RequestParam int participants) throws BoredException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(boredService.getActivityByParticipants(participants));
    }
}
