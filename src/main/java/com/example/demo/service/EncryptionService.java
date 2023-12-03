package com.example.demo.service;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private final StringEncryptor encryptor;

    @Autowired
    public EncryptionService(StringEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    public String encrypt(String plaintext) {
        return encryptor.encrypt(plaintext);
    }

    public String decrypt(String ciphertext) {
        return encryptor.decrypt(ciphertext);
    }
}

