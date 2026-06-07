package com.chat.ChatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  //this app will use websocket to handle real time communication
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{

//    How does client's message REACH the server?
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080") // Allow all origins (for development purposes)
                .withSockJS(); // Enable SockJS fallback options

    }

//    Problem 2 — How does server's message REACH all clients?
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry)
    {
        registry.enableSimpleBroker("/topic"); //messages sent to /topic will be handled by the broker and sent to clients subscribed to that topic
        registry.setApplicationDestinationPrefixes("/app");
        //expect message with /app/sendmessage
    }


}
