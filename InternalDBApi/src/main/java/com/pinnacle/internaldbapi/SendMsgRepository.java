package com.pinnacle.internaldbapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMsgRepository extends JpaRepository<SmsRequest, Integer> {

}
