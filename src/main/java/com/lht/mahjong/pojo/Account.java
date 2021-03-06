package com.lht.mahjong.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Account {
    @Id
    private String account;

    private String password;

    private List<Long> roleList;
}
