package org.example.mcpclient.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools")
public class ToolController {
    private final ChatClient chatClient ;
    public ToolController(ChatClient.Builder aiClientBuilder, ToolCallbackProvider mcpTools) {
        this.chatClient = aiClientBuilder
                .defaultTools(mcpTools)
                .build() ;
    }

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(String prompt) {
        System.err.println(prompt) ;
        String response = this.chatClient
                .prompt(prompt)
                .call().content() ;
        return ResponseEntity.ok(response) ;
    }

    @GetMapping("/ip")
    public ResponseEntity<String> getIpAddress(String prompt) {
        System.err.println(prompt) ;
        String response = this.chatClient
                .prompt(prompt)
                .call().content() ;
        return ResponseEntity.ok(response) ;
    }
}
