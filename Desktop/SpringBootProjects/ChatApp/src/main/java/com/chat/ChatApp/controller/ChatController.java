package com.chat.ChatApp.controller;

import com.chat.ChatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController
{
    // /app/sendMessage  --> brodcasted to /topic/messages
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message)
    {
        return message;
    }

    //localhost:8080/chat
    @GetMapping("chat")
    public String chat()
    {
        return "chat";
    }
}
