package com.lht.mahjong.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Account {
    @Id
    private String account;

    @Field
    private String password;
}
