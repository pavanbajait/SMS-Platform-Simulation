package com.pinnacle.internaldbapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InternalDbController {

    @Autowired
    private DbService dbService;

    @PostMapping("/insertSendMsg")
    public void insertSendMsg(@RequestBody SmsRequest smsRequest) {
        dbService.insertSendMsg(smsRequest);
    }

    @GetMapping("/getAccountId")
    public Integer getAccountId(@RequestParam String username, @RequestParam String password) {
        return dbService.getAccountId(username, password);
    }
}
