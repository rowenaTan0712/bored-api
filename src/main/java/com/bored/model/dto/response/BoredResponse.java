package com.bored.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoredResponse {

    private long key;
    private String activity;
    private String link;
    private int accessibility;
    private String type;
    private int participants;
    private double price;
}
