package com.lht.mahjong;

import com.lht.mahjong.cache.LoginCache;
import com.lht.mahjong.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginCache loginCache;

    @Test
    void createAccountTest() {
        Account account = new Account();
        account.setAccount("aaaa");
        account.setPassword("bbbb");
        loginCache.saveAccount(account);
        Account aaaa = loginCache.getAccount("aaaa");
        System.out.println(aaaa.getAccount() + "______" + aaaa.getPassword());
    }
}
