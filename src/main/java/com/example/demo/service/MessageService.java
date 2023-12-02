package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {
    
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public void saveOrUpdate(Message entity){
        repository.save(entity);
    }

    public void saveMessage(String content) {
        Message message = new Message();
        message.setMessage(content);
        repository.save(message);
    }
}
