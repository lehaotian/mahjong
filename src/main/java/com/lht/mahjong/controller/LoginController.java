package com.lht.mahjong.controller;

import com.lht.mahjong.servide.LoginService;
import com.lht.mahjong.servide.LoginStatus;
import com.lht.mahjong.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(String accountName, String password) {
        LoginStatus login = loginService.login(accountName, password);
        return JacksonUtil.toString(login);
    }
}
