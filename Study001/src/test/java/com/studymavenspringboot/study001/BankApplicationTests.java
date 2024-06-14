package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathExam.AccountService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankApplicationTests {
    @Test
    public void addAccountTest(){
        AccountService accountService = new AccountService();

        accountService.addAccount("홍길동", "111-111", 20000);

    }
}
