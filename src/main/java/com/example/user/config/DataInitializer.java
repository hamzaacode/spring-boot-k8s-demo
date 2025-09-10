package com.example.user.config;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        userRepository.deleteAll();

        // Create sample users
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPhoneNumber("1234567890");
        user1.setAge(30);

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setEmail("jane.smith@example.com");
        user2.setPhoneNumber("0987654321");
        user2.setAge(25);

        User user3 = new User();
        user3.setFirstName("Mike");
        user3.setLastName("Johnson");
        user3.setEmail("mike.johnson@example.com");
        user3.setPhoneNumber("5555555555");
        user3.setAge(35);

        // Save users to database
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        System.out.println("Sample data initialized successfully!");
        System.out.println("Created " + userRepository.count() + " users.");
    }
}
