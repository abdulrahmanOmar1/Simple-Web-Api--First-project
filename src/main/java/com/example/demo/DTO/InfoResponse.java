package com.example.demo.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class InfoResponse {
    private String time;
    private String clientAddress;
    private String hostName;
    private Map<String, String> headers;

    public InfoResponse(String time, String clientAddress, String hostName, Map<String, String> headers) {
        this.time = time;
        this.clientAddress = clientAddress;
        this.hostName = hostName;
        this.headers = headers;
    }

}
