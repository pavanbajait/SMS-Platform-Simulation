package com.pinnacle.backendthreadapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

import java.util.List;

@SpringBootApplication
public class BackendThreadAppApplication {

    @Autowired
    private SendMsgRepository sendMsgRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendThreadAppApplication.class, args);
    }

    @PostConstruct
    public void startProcessing() {
        new Thread(() -> {
            while (true) {
                List<SmsRequest> newMessages = sendMsgRepository.findByStatus("NEW");
                for (SmsRequest message : newMessages) {
                    
                    sendMsgRepository.updateMessageStatus(message.getId(), "INPROCESS");
                    
                    String response = sendSmsToOperator(message);
                    sendMsgRepository.updateMessageStatusAndResponse(message.getId(), "SENT", response);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    private String sendSmsToOperator(SmsRequest message) {
        return "Simulated response";
    }
}

