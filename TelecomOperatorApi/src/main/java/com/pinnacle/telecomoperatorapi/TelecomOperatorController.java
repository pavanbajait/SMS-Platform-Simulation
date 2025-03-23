package com.pinnacle.telecomoperatorapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TelecomOperatorController {

    @GetMapping("/telco/smsc")
    public String sendSms(
            @RequestParam int accountId,
            @RequestParam long mobile,
            @RequestParam String message) {
        if (String.valueOf(mobile).length() != 10 || message.isEmpty()) {
            return "STATUS: REJECTED~~ RESPONSE_CODE: FAILURE";
        }
        return "STATUS: ACCEPTED~~RESPONSE_CODE: SUCCESS~~" + UUID.randomUUID().toString();
    }
}

