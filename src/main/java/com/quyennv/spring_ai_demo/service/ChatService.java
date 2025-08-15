package com.quyennv.spring_ai_demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.quyennv.spring_ai_demo.dto.request.ChatRequest;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public String chat(ChatRequest request) {
        return chatClient.prompt(request.message()).call().content();
    }
}
