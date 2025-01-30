package com.fiap.gateway.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ApplicationController {

  @GetMapping
  public ResponseEntity<Map<String, Object>> index() {
    try {
      Map<String, Object> body = new LinkedHashMap<>();
      body.put("Application", "Gateway Application");
      body.put("Hostname", InetAddress.getLocalHost().getHostName());
      body.put("IP", InetAddress.getLocalHost().getHostAddress());
      body.put("Address", InetAddress.getLocalHost().getAddress());
      body.put("getLocalHost", InetAddress.getLocalHost().toString());

      return ResponseEntity.ok(body);
    } catch (UnknownHostException e) {
      return ResponseEntity.status(500)
          .body(Map.of("error", "Unable to retrieve host information"));
    }
  }
}
