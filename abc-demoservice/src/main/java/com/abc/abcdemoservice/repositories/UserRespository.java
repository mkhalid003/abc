package com.abc.abcdemoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.abcdemoservice.entities.UserModel;

@Repository
public interface UserRespository extends JpaRepository<UserModel, Long> {
}