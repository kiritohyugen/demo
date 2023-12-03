package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {
    
    private final MessageRepository repository;
    private final EncryptionService encryptionService;

    @Autowired
    public MessageService(MessageRepository repository,EncryptionService encryptionService ){
        this.repository = repository;
        this.encryptionService = encryptionService;
    }

    public void saveOrUpdate(Message entity){
        repository.save(entity);
    }

    public void saveMessage(String content) {
        Message message = new Message();
        message.setMessage(encryptionService.encrypt(content));
        repository.save(message);
    }

    public List<String> getAllMessages(){
        List <Message> messages =  repository.findAll();
        return messages.stream().map(message -> encryptionService.decrypt(message.getMessage())).collect(Collectors.toList());

    }
}
