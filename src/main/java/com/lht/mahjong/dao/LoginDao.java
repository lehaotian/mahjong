package com.lht.mahjong.dao;

import com.lht.mahjong.pojo.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends MongoRepository<Account, String> {

}
