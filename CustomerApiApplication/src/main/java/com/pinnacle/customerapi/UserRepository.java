package com.pinnacle.customerapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.accountId FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Integer findAccountIdByUsernameAndPassword(String username, String password);
}

