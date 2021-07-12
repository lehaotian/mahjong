package com.lht.mahjong.pojo.battle;

import lombok.Data;

import java.util.List;

@Data
public class BattleInfo {
    private List<BattlePlayer> playerList;
    private List<Integer> mahjong;
    private List<Integer> step;
    private int stepTime;
    private long startTime;
    private long endTime;
}
