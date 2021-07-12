package com.lht.mahjong.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class BattleCache {
    @Autowired
    private StringRedisTemplate redisTemplate;
}
