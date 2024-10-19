package com.RViP.gateway.controller;

import com.RViP.gateway.service.ReaderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ReaderService readerService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest authRequest) {
        return Map.of("token", readerService.generateJwt(authRequest.getUsername()));
    }
}

@Data
class AuthRequest {
    private String username;
}
