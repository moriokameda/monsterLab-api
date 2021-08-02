package com.moriokameda.monsterlab.domain.model;

import lombok.Getter;
import org.seasar.doma.Domain;

/**
 * お気に入りカウント数
 * @author moriokameda
 */
@Domain(valueType = int.class)
@Getter
public class FavoriteCount {

    private final int value;

    public FavoriteCount(int value) {
        this.value = value;
    }
}
