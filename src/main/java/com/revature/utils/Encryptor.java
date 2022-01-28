package com.revature.utils;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public String encoder(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte[] hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
        return String.format("%040x", new BigInteger(1,hashedPassword));
    }
}
