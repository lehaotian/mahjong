package com.lht.mahjong.pojo.battle;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BattleRoom {
    private long roomId;
    private List<Long> playerList;
    private BattleInfo battleInfo;
    private List<Map<Long, Integer>> record;
    private long startTime;
    private long endTime;
}
