package com.lht.mahjong.pojo.battle;

import lombok.Data;

import java.util.List;

@Data
public class BattlePlayer {
    private long playerId;
    /**
     * 牌
     */
    private List<Card> board;
    /**
     * 已打出的牌
     */
    private List<Integer> discard;
    /**
     * 当前摸到的牌
     */
    private int extract;
}
