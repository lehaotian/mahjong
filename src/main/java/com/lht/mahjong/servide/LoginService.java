package com.lht.mahjong.servide;

import com.lht.mahjong.cache.LoginCache;
import com.lht.mahjong.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginCache loginCache;

    public LoginStatus login(String accountName, String password) {
        Account account = loginCache.getAccount(accountName);
        if (account.getAccount() == null) {
            createAccount(account, accountName, password);
            return LoginStatus.CREATE_NEW_ACCOUNT;
        } else {
            if (password.equals(account.getPassword())) {
                return LoginStatus.SUCCESS;
            } else {
                return LoginStatus.PASSWORD_ERROR;
            }
        }
    }

    public void createAccount(Account account, String accountName, String password) {
        account.setAccount(accountName);
        account.setPassword(password);
        loginCache.saveAccount(account);
    }
}
