 /*package com.example.userregistration.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.userregistration.model.Users;
import com.example.userregistration.repository.UserJpaRepository;
import com.example.userregistration.service.EmailService;

@RestController
public class LoginRestController {

    @Autowired
    private UserJpaRepository userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Users user) {
        // Check if the email already exists
        if (userService.existsByEmailId(user.getEmailId())) {
            return "User with this email already exists!";
        }

        
        userService.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user) {
        Users existingUser = userService.findByEmailId(user.getEmailId());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid email or password";
        }
    }

    @PostMapping("/forgot-password")
    public String processForgotPasswordForm(@RequestParam("email") String email) {
        Users user = userService.findByEmailId(email);
        if (user != null) {
        	 // Generate a unique token
            String token = UUID.randomUUID().toString();
            // Save the token in the database for the user
            user.setResetToken(token);
            userService.save(user);
            // Construct the reset password link
            String resetLink = "http" + "://" + "localhost" + ":" + "8080" + "/reset-password?token=" + token;
            // Send an email with the reset link
            emailService.sendResetPasswordEmail(email, resetLink);
            return "Password reset instructions sent to your email!";
        } else {
            return "User with this email does not exist";
        }
    }

    @PostMapping("/reset-password")
    public String processResetPasswordForm(@RequestParam("token") String token,
                                           @RequestParam("password") String password) {
        Users user = userService.findByResetToken(token);
        if (user != null) {
        	user.setPassword(password);
            user.setResetToken(null);
            userService.save(user);
            return "Password reset successful!";
        } else {
            return "Invalid reset token";
        }
    }
    //http://localhost:8080/
}
*/