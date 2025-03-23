package com.pinnacle.backendthreadapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMsgRepository extends JpaRepository<SmsRequest, Integer> {

	List<SmsRequest> findByStatus(String string);

	void updateMessageStatus(long id, String string);

	void updateMessageStatusAndResponse(long id, String string, String response);

}
