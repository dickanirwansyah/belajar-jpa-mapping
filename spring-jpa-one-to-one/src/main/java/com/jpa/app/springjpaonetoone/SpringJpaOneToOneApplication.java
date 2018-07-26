package com.jpa.app.springjpaonetoone;

import com.jpa.app.springjpaonetoone.entity.Gender;
import com.jpa.app.springjpaonetoone.entity.User;
import com.jpa.app.springjpaonetoone.entity.UserProfile;
import com.jpa.app.springjpaonetoone.repository.UserProfileRepository;
import com.jpa.app.springjpaonetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class SpringJpaOneToOneApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOneToOneApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		User user = new User("Muhammad", "dicka nirwansyah", "dickanirwansyah@gmail.com", "root");

		Calendar birthday = Calendar.getInstance();
		birthday.set(1996, 07, 19);

		UserProfile userProfile = new UserProfile("08788767272", Gender.MALE,
				"Jl.Cilandak No.36");

		user.setUserProfile(userProfile);

		userProfile.setUser(user);

		userRepository.save(user);

	}
}
