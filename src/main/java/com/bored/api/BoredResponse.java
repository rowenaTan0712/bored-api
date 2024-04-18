package com.bored.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Bored {

    @Getter @Setter private long key;
    @Getter @Setter private String activity;
    @Getter @Setter private String link;
    @Getter @Setter private int accessibility;
    @Getter @Setter private String type;
    @Getter @Setter private int participants;
    @Getter @Setter private double price;
}
