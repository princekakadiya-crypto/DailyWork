package com.tss.spring_security.repository;

import com.tss.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUserName(String userName);
    Optional<User> findByUserName(String userName);
}
