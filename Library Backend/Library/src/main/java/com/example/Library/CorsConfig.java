package com.example.Library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        System.out.println("CorsFilter initialized");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        // Specify allowed origins (replace with your frontend origin)
        config.addAllowedOrigin("http://localhost:5500");
        config.addAllowedOrigin("http://192.168.1.5:5500");

        // Specify allowed HTTP methods, headers, etc. as needed
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // Apply CORS configuration to all paths
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
