package com.loginsystem.mvc.share;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "1234567890MNBVCXZASDFGHJKLPOIUYTREWQmnbvcxzasdfghjklpoiuytrewq";

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder restValue = new StringBuilder(length);

        for(int i=0; i<length; i++){
            restValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(restValue);
    }


}
