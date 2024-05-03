package com.rickiedixon.runnerz;

import com.rickiedixon.runnerz.run.Location;
import com.rickiedixon.runnerz.run.Run;
import com.rickiedixon.runnerz.run.RunRepository;
import com.rickiedixon.runnerz.user.User;
import com.rickiedixon.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(UserRestClient client){
		return args -> {
			List<User> users = client.findAll();
			System.out.println(users);

			User user = client.findById(3);
			System.out.println(user);
		};
	}

	}
