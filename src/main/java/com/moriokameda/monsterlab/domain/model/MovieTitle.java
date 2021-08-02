package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;

@Getter
public class MovieTitle {
    private final String value;

    public MovieTitle(String value) {
        this.value = value;
    }
}
