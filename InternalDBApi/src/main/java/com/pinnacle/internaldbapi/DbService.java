package com.pinnacle.internaldbapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private SendMsgRepository sendMsgRepository;

    @Autowired
    private UserRepository userRepository;

    public void insertSendMsg(SmsRequest smsRequest) {
        sendMsgRepository.save(smsRequest);
    }

    public Integer getAccountId(String username, String password) {
        return userRepository.findAccountIdByUsernameAndPassword(username, password);
    }
}