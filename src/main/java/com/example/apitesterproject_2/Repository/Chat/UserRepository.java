package com.example.apitesterproject_2.Repository.Chat;

import com.example.apitesterproject_2.Model.Chat.Chat;
import com.example.apitesterproject_2.Model.Chat.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {



}
