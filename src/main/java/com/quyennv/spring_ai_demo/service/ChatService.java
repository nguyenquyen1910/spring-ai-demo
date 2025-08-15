package com.quyennv.spring_ai_demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import com.quyennv.spring_ai_demo.dto.request.ChatRequest;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public String chat(ChatRequest request) {
        SystemMessage systemMessage = new SystemMessage("""
            You are QuyenNV's AI assistant.
            Your name is Jr.
                """);
        UserMessage userMessage = new UserMessage(request.message());

        Prompt prompt = new Prompt(systemMessage, userMessage);

        return chatClient.prompt(prompt).call().content();
    }

    public String chatWithImage(MultipartFile file, String message) {
        Media media = Media.builder()
            .mimeType(MimeTypeUtils.parseMimeType(file.getContentType()))
            .data(file.getResource())
            .build();

        ChatOptions chatOptions = ChatOptions.builder()
            .temperature(1D)
            .build();


        return chatClient.prompt()
            .options(chatOptions)
            .system("""
                You are QuyenNV's AI assistant.
                Your name is Jr.
                """)
            .user(promptUserSpec 
            -> promptUserSpec.media(media)
            .text(message))
            .call().content();
    }
}
