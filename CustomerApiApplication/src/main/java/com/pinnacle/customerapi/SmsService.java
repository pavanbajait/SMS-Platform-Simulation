package com.pinnacle.customerapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SmsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, SmsRequest> kafkaTemplate;

    public ResponseEntity<String> processSmsRequest(String username, String password, long mobile, String message) {
        
        Integer accountId = userRepository.findAccountIdByUsernameAndPassword(username, password);
        if (accountId == null || String.valueOf(mobile).length() != 10 || message.isEmpty()) {
            return ResponseEntity.status(400).body("STATUS: REJECTED~~RESPONSE_CODE: FAILURE");
        }

        
        SmsRequest smsRequest = new SmsRequest(UUID.randomUUID().toString(), accountId, mobile, message, "NEW");
        
        kafkaTemplate.send("sms_topic", smsRequest);

        return ResponseEntity.ok("STATUS: ACCEPTED~~RESPONSE_CODE: SUCCESS~~" + smsRequest.getAckId());
    }
}