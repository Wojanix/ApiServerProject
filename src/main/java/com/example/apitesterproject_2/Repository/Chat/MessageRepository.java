package com.example.apitesterproject_2.Repository.Chat;

import com.example.apitesterproject_2.Model.Chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * from message m WHERE m.chat_address like :address ", nativeQuery = true)
    List<Message> findAllByChatAddress(@Param("address") String address);


    @Query(value = "SELECT * from message m WHERE m.chat_address like :address order by m.message_number desc LIMIT 1", nativeQuery = true)
    Message findLastByAddress(@Param("address") String address);
}
