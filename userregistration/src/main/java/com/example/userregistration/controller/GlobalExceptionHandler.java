package com.example.userregistration.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        // You can handle the exception here and return a custom error page or message
        return "error"; // Assuming you have an error.html Thymeleaf template
    }
}