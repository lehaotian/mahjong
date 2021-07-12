package com.lht.mahjong;

import com.lht.mahjong.controller.LoginController;
import com.lht.mahjong.pojo.Account;
import com.lht.mahjong.service.login.LoginStatus;
import com.lht.mahjong.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginController loginController;

    @Test
    void createAccountTest() {
        Account account = new Account();
        account.setAccount("aaaa");
        account.setPassword("bbbb");
        String login = loginController.login(account);
        String status = JacksonUtil.toObject(login, String.class);
        assertEquals(status, LoginStatus.SUCCESS.name());
        account.setPassword("ccccc");
        String login2 = loginController.login(account);
        String status2 = JacksonUtil.toObject(login2, String.class);
        assertEquals(status2, LoginStatus.PASSWORD_ERROR.name());
    }
}
