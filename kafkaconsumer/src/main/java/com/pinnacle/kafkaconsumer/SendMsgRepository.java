package com.pinnacle.kafkaconsumer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMsgRepository extends JpaRepository<SmsRequest, Integer> {

}
