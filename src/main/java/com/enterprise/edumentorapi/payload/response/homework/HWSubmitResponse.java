package com.enterprise.edumentorapi.payload.response.homework;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class HWSubmitResponse {

    private Long id;
    private Long userId;
    private Long hwId;
}
