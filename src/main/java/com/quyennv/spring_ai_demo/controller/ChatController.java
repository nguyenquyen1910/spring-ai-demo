package com.quyennv.spring_ai_demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quyennv.spring_ai_demo.dto.request.ChatRequest;
import com.quyennv.spring_ai_demo.service.ChatService;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }

    @PostMapping("/chat-with-image")
    String chatWithImage(@RequestParam("file") MultipartFile file,
                        @RequestParam("message") String message) {
        return chatService.chatWithImage(file, message);                    
    }
}
