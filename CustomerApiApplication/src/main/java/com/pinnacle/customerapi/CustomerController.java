package com.pinnacle.customerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/telco/sendmsg")
    public ResponseEntity<String> sendMessage(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam long mobile,
            @RequestParam String message) {
        return smsService.processSmsRequest(username, password, mobile, message);
    }
}