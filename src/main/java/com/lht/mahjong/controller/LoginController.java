package com.lht.mahjong.controller;

import com.lht.mahjong.pojo.Account;
import com.lht.mahjong.service.login.LoginService;
import com.lht.mahjong.service.login.LoginStatus;
import com.lht.mahjong.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(Account account) {
        LoginStatus login = loginService.login(account.getAccount(), account.getPassword());
        return JacksonUtil.toString(login);
    }
}
