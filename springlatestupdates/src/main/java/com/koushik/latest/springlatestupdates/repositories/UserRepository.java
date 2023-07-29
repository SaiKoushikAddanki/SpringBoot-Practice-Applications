package com.koushik.latest.springlatestupdates.repositories;

import com.koushik.latest.springlatestupdates.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

}
