package com.enterprise.edumentorapi.payload.request.auth;

import lombok.Data;

@Data
public class TokenRefreshRequest {

    private String refreshToken;
}
