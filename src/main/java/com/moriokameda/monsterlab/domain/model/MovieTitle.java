package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;
import org.seasar.doma.Domain;

@Domain(valueType = String.class)
@Getter
public class MovieTitle {
    private final String value;

    public MovieTitle(String value) {
        this.value = value;
    }
}
