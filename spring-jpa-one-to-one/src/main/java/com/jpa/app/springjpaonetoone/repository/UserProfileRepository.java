package com.jpa.app.springjpaonetoone.repository;

import com.jpa.app.springjpaonetoone.entity.User;
import com.jpa.app.springjpaonetoone.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
