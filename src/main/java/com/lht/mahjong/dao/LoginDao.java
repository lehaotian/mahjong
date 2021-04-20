package com.lht.mahjong.dao;

import com.lht.mahjong.pojo.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LoginDao extends ReactiveMongoRepository<Integer, Account> {

}
