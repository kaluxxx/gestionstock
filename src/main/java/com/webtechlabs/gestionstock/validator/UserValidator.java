package com.webtechlabs.gestionstock.validator;

import com.webtechlabs.gestionstock.dto.UserDto;

import java.util.regex.Pattern;

public class UserValidator {

    public static void validate(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        String upperCasePattern = "(?=.*[A-Z])";
        String lowerCasePattern = "(?=.*[a-z])";
        String digitPattern = "(?=.*\\d)";
        String specialCharPattern = "(?=.*[^a-zA-Z0-9])";

        return Pattern.compile(upperCasePattern).matcher(password).find()
                && Pattern.compile(lowerCasePattern).matcher(password).find()
                && Pattern.compile(digitPattern).matcher(password).find()
                && Pattern.compile(specialCharPattern).matcher(password).find();
    }
}
