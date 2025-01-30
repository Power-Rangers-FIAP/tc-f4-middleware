package com.fiap.gateway.configurations;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Value("${app.allowed-origin-patterns:}")
  private String urlAllowOriginPatterns;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.csrf(ServerHttpSecurity.CsrfSpec::disable)
        .cors(corsSpec -> corsSpec.configurationSource(corsConfigurationSource()))
        .headers(
            headers ->
                headers.frameOptions(
                    frameOptions ->
                        frameOptions.mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN)))
        .authorizeExchange(
            exchange ->
                exchange
                    .pathMatchers("/")
                    .permitAll()
                    .pathMatchers("/ms_client/**")
                    .permitAll()
                    .pathMatchers("/ms_product_catalog/**")
                    .permitAll()
                    .pathMatchers("/ms_order_manager/**")
                    .permitAll()
                    .pathMatchers("/ms_logistics/**")
                    .permitAll()
                    .anyExchange()
                    .authenticated());

    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedHeaders(
        List.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CACHE_CONTROL, HttpHeaders.CONTENT_TYPE));
    corsConfiguration.setAllowedOriginPatterns(
        Arrays.asList(StringUtils.split(urlAllowOriginPatterns, ",")));
    corsConfiguration.setAllowedMethods(
        List.of(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name(),
            HttpMethod.OPTIONS.name(),
            HttpMethod.PATCH.name()));
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setExposedHeaders(List.of(HttpHeaders.AUTHORIZATION));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);

    return source;
  }
}
