package com.enterprise.edumentorapi.payload.response.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int code;

    private String error;

    private String message;
}
