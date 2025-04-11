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
    private final ChatClient chatClient;

    /*
    你引入的依赖（如 spring-ai-alibaba-starter）会自动：
    根据 spring.ai.alibaba.* 配置创建一个 AlibabaChatClient
    也会自动注册一个 ChatClient.Builder Bean，可以根据这个Builder 创建一个 自定义的绑定了工具的ChatClient
    它内部已经帮你设好模型名、API key、URL 等参数
     */
    public ToolController(ChatClient.Builder aiClientBuilder, ToolCallbackProvider mcpTools) {
        this.chatClient = aiClientBuilder
                .defaultTools(mcpTools)
                .build();
    }

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(String prompt) {
        System.err.println(prompt);
        String response = this.chatClient
                .prompt(prompt)
                .call().content();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ip")
    public ResponseEntity<String> getIpAddress(String prompt) {
        System.err.println(prompt);
        String response = this.chatClient
                .prompt(prompt)
                .call().content();
        return ResponseEntity.ok(response);
    }
}
