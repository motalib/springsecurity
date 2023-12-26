package com.motalib.springsecurity;

import com.motalib.springsecurity.entity.Role;
import com.motalib.springsecurity.entity.User;
import com.motalib.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.motalib.springsecurity.entity"})  // force scan JPA entities
@RequiredArgsConstructor
public class SpringsecurityApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	public void run(String... args) {
		userRepository.findByRole(Role.ADMIN)
				.orElseGet(() -> userRepository.save(User.builder()
						.email("admin@gmail.com")
						.firstName("admin")
						.lastName("admin")
						.role(Role.ADMIN)
						.password(passwordEncoder.encode("admin"))
						.build()));
	}
}
