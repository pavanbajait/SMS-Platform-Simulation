package com.pinnacle.kafkaconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SmsConsumer {

    @Autowired
    private SendMsgRepository sendMsgRepository;

    @KafkaListener(topics = "sms_topic", groupId = "sms_group")
    public void consumeSms(SmsRequest smsRequest) {
        sendMsgRepository.save(smsRequest);
    }
}
