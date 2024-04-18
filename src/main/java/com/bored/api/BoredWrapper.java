package com.bored.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class BoredWrapper {

    @Getter @Setter private String activityName;
    @Getter @Setter private String activityType;
    @Getter @Setter private double price;
    @Getter @Setter private int participantNumber;
    @Getter @Setter private String link;
}
