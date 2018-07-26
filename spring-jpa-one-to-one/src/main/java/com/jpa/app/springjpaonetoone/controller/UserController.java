package com.jpa.app.springjpaonetoone.controller;

import com.jpa.app.springjpaonetoone.entity.Gender;
import com.jpa.app.springjpaonetoone.entity.User;
import com.jpa.app.springjpaonetoone.entity.UserProfile;
import com.jpa.app.springjpaonetoone.exception.NotFoundException;
import com.jpa.app.springjpaonetoone.repository.UserProfileRepository;
import com.jpa.app.springjpaonetoone.repository.UserRepository;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping
    public User create(@RequestBody User user){
        User usr = newUser(user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword());

        UserProfile profile = newUserprofile(user.getUserProfile().getPhone(),
                user.getUserProfile().getGender(),
                user.getUserProfile().getAddress());

        usr.setUserProfile(profile);
        profile.setUser(usr);
        return userRepository.save(usr);
    }


    @GetMapping(value = "/{userId}")
    public Optional<User> getId(@PathVariable("userId") long userId){
        Optional<User> usr = userRepository.findById(userId);
        if (!usr.isPresent()){
            throw new NotFoundException("data tidak ada");
        }
        return usr;
    }

    @GetMapping
    public List<User> list(){
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()){
            users.add(user);
        }
        return users;
    }

    private User newUser(String firstname, String lastname, String email, String password){
        return User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(password)
                .build();
    }

    private UserProfile newUserprofile(String phone, Gender gender,  String address){
        return UserProfile.builder()
                .phone(phone)
                .gender(gender)
                .address(address)
                .build();
    }
}
