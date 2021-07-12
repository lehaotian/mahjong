package com.lht.mahjong.service.login;

import com.lht.mahjong.cache.LoginCache;
import com.lht.mahjong.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginCache loginCache;

    public LoginStatus login(String accountName, String password) {
        Optional<Account> account = loginCache.getAccount(accountName);
        if (account.isPresent()) {
            if (password.equals(account.get().getPassword())) {
                return LoginStatus.SUCCESS;
            } else {
                return LoginStatus.PASSWORD_ERROR;
            }
        } else {
            createAccount(accountName, password);
            return LoginStatus.CREATE_NEW_ACCOUNT;
        }
    }

    public Account createAccount(String accountName, String password) {
        Account account = new Account();
        account.setAccount(accountName);
        account.setPassword(password);
        loginCache.saveAccount(account);
        return account;
    }
}
