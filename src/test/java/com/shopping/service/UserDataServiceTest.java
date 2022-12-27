package com.shopping.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserDataServiceTest {

    @Autowired
    UserDataService userDataService;

    @Test
    public void testGetUserDetails() {
        System.out.println(userDataService.getUserDetails("admin"));
    }
}