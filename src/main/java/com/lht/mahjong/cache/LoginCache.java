package com.lht.mahjong.cache;

import com.lht.mahjong.dao.LoginDao;
import com.lht.mahjong.pojo.Account;
import com.lht.mahjong.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginCache {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Optional<Account> getAccount(String accountName) {
        String json = (String) redisTemplate.opsForHash().get(RedisKey.account.name(), accountName);
        if (json == null) {
            Optional<Account> account = loginDao.findById(accountName);
            account.ifPresent(this::saveByMongo);
            return account;
        }
        Account account = JacksonUtil.toObject(json, Account.class);
        return Optional.of(account);
    }

    public void saveAccount(Account account) {
        saveByMongo(account);
        loginDao.save(account);
    }

    private void saveByMongo(Account account) {
        redisTemplate.opsForHash().put(RedisKey.account.name(), account.getAccount(), JacksonUtil.toString(account));
    }

}
