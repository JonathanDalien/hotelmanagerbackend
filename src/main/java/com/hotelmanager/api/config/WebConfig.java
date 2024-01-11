package com.hotelmanager.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//WebConfig
@Configuration
public class WebConfig {

    //CORS Config
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Alle Pfade
                        .allowedOrigins("http://localhost:3000") // URL Ihrer React-App
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Erlaubte HTTP-Methoden
                        .allowedHeaders("*") // Erlaubte Header
                        .allowCredentials(true);
            }
        };
    }
}
