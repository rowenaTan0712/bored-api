package com.bored.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDTO {

    private String activityName;
    private String activityType;
    private double price;
    private int participantNumber;
    private String link;
}
