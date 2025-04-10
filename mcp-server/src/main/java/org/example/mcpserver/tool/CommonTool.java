package org.example.mcpserver.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.Map;

public class CommonTool {

    @Tool(description = "获取当前天气预报")
    String getCurrentWeather(String city) {
        System.err.printf("准备查询【%s】天气预报%n", city) ;
        RestClient client = RestClient.create(URI.create("https://api.vvhan.com")) ;
        Map<?, ?> result = client.get()
                .uri("/api/weather?city={0}", city)
                .retrieve()
                .body(Map.class) ;
        try {
            return new ObjectMapper().writeValueAsString(result) ;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e) ;
        }
    }

    @Tool(description = "获取IP地址详细信息")
    String getIpAddressInfo(String ip) {
        System.err.printf("准备查询【%s】详细信息%n", ip) ;
        RestClient client = RestClient.create(URI.create("https://api.vvhan.com")) ;
        Map<?, ?> result = client.get()
                .uri("/api/ipInfo?ip={0}", ip)
                .retrieve()
                .body(Map.class) ;
        try {
            return new ObjectMapper().writeValueAsString(result) ;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e) ;
        }
    }

}
