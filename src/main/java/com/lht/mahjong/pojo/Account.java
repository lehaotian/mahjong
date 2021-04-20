package com.lht.mahjong.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Account {
    @Id
    private String account;

    @Field
    private String password;
}
