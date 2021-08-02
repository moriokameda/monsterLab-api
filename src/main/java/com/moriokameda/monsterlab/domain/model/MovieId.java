package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;

import java.math.BigInteger;

/**
 * Movie id Domain
 */
@Getter
public class MovieId {

    private final BigInteger value;

    public MovieId(BigInteger value) {
        this.value = value;
    }

}
