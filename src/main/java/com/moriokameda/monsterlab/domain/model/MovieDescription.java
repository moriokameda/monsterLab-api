package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;
import org.seasar.doma.Domain;

/**
 * 動画説明値オブジェクト
 * @author moriokameda
 */
@Getter
@Domain(valueType = String.class)
public class MovieDescription {

    private final String value;

    public MovieDescription(String value) {
        this.value = value;
    }
}
