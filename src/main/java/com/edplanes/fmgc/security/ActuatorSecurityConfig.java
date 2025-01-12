package com.edplanes.fmgc.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class ActuatorSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.securityMatcher(EndpointRequest.to("health", "prometheus"));

    http.authorizeHttpRequests(
        (requests) -> requests.requestMatchers(HttpMethod.GET).permitAll());
    return http.build();
  }
}
