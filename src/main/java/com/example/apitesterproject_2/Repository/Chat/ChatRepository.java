package com.example.apitesterproject_2.Repository.Chat;

import com.example.apitesterproject_2.Model.Chat.Chat;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query(value = "SELECT * from chat c WHERE c.address like :address ", nativeQuery = true)
    Chat getChatByAddress(@Param("address") String address);


}
