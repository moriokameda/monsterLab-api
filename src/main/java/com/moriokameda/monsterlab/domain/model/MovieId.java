package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;
import org.seasar.doma.Domain;

import java.math.BigInteger;

/**
 * Movie id Domain
 */
@Domain(valueType = int.class)
@Getter
public class MovieId {

    private final BigInteger value;

    public MovieId(BigInteger value) {
        this.value = value;
    }

}
