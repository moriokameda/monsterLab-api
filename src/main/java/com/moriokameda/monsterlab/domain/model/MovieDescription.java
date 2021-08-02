package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;

/**
 * 動画説明値オブジェクト
 * @author moriokameda
 */
@Getter
public class MovieDescription {

    private final String value;

    public MovieDescription(String value) {
        this.value = value;
    }
}
