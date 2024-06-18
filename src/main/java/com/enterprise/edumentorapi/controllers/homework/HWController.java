package com.enterprise.edumentorapi.controllers.homework;

import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import com.enterprise.edumentorapi.payload.response.homework.HWResponse;
import com.enterprise.edumentorapi.service.homework.HWService;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.HWResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/homework")
@RequiredArgsConstructor
public class HWController {

    private final HWService hwService;
    private final HWResponseMapper hwResponseMapper;

    @PostMapping("lesson/{lessonId}/create")
    public ResponseEntity<HWResponse> createHW(@PathVariable Long lessonId, @RequestBody HWRequest hwRequest) {
        HomeWork hw = hwService.createHW(lessonId, hwRequest);
        HWResponse hwResponse = hwResponseMapper.toHWResponse(hw);
        return ResponseEntity.ok(hwResponse);
    }
}