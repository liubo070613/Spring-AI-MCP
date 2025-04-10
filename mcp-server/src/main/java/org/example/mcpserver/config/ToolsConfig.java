package org.example.mcpserver.config;

import org.example.mcpserver.tool.CommonTool;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolsConfig {
    @Bean
    ToolCallbackProvider tools() {
        ToolCallback[] toolCallbacks = ToolCallbacks.from(new CommonTool());
        return ToolCallbackProvider.from(toolCallbacks);
    }
}
