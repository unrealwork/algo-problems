package com.hackerrank.java.advanced;

import java.io.BufferedInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Usage {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final String message = scanner.nextLine();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(message.getBytes());
            byte[] md5Bytes = digest.digest();
            /* Print the encoded value in hexadecimal */
            for (byte b : md5Bytes) {
                System.out.format("%02x", b);
            }
        }
    }
}
