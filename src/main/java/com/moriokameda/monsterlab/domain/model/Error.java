package com.moriokameda.monsterlab.domain.model;

import lombok.Data;

/**
 * Errorレスポンスデータ
 */
@Data
public class Error {
    private int code;
    private String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
