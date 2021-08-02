package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;

/**
 * お気に入りカウント数
 * @author moriokameda
 */
@Getter
public class FavoriteCount {

    private final int value;

    public FavoriteCount(int value) {
        this.value = value;
    }
}
