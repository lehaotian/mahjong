package com.lht.mahjong.servide;

public enum LoginStatus {
    SUCCESS(0),
    PASSWORD_ERROR(1),
    CREATE_NEW_ACCOUNT(2),
    ;
    private final int status;

    LoginStatus(int status) {
        this.status = status;
    }
}
