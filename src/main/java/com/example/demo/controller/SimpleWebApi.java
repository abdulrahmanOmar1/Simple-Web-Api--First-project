package com.example.demo.controller;


import com.example.demo.DTO.InfoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SimpleWebApi {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }
    @GetMapping("/info")
    public InfoResponse getInfo(HttpServletRequest request, @RequestHeader Map<String, String> headers) throws UnknownHostException, java.net.UnknownHostException {
        String requestTime = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);

        String clientIpAddress = request.getRemoteAddr();

        String hostName = InetAddress.getLocalHost().getHostName();

        return new InfoResponse(requestTime, clientIpAddress, hostName, headers);
    }
}


