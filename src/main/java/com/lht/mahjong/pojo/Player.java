package com.lht.mahjong.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Player {
    @Id
    private long playerId;

    private String playerName;

    private int card;
}
