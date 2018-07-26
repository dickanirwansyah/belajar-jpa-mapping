package com.jpa.app.springjpaonetoone.repository;

import com.jpa.app.springjpaonetoone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByIdIn(Long id);
}
