package com.pinnacle.kafkaconsumer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class SmsRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ackId;
    private int accountId;
    private long mobile;
    private String message;

    public SmsRequest(String ackId, int accountId, long mobile, String message) {
        this.ackId = ackId;
        this.accountId = accountId;
        this.mobile = mobile;
        this.message = message;
    }

	public String getAckId() {
		return ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    

}
