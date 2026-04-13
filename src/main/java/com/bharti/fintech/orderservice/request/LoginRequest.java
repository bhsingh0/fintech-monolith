package com.bharti.fintech.orderservice.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
