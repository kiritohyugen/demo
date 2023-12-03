package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;

@RestController
public class MessageController {

    @GetMapping("/hello")
    public String sayGreeting(@RequestParam String name) {
        return " Hello " + name + " Bhatia !";
    }

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/save-message")
    public String saveMessage(@RequestParam String content) {
        messageService.saveMessage(content);
        return content + "  -> Message saved successfully!";
    }

    @GetMapping("/get-all-messages")
    public List<String> getAllMessages() {
        return messageService.getAllMessages();
    }

}
