package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.AssignmentHw;
import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.entity.HomeWorkSubmission;
import com.enterprise.edumentorapi.payload.response.homework.AssigmentResponse;
import com.enterprise.edumentorapi.payload.response.homework.HWResponse;
import com.enterprise.edumentorapi.payload.response.homework.HWSubmitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HWResponseMapper {
    public HWResponse toHWResponse(HomeWork hw) {
        HWResponse hwResponse = new HWResponse();
        hwResponse.setHomeWorkId(hw.getHomeWorkId());
        hwResponse.setTitle(hw.getTitle());
        hwResponse.setDescription(hw.getDescription());
        hwResponse.setIsMandatory(hw.getIsMandatory());
        hwResponse.setAssigmentResponse(toAssigmentResponse(hw.getAssignmentHw()));
        return hwResponse;
    }

    public AssigmentResponse toAssigmentResponse(AssignmentHw assignmentHw) {
        return new AssigmentResponse(assignmentHw.getAssignmentTask(), assignmentHw.getAssigmentUrl());
    }

    public HWSubmitResponse toHWSubmitResponse(HomeWorkSubmission hwSubmission) {
        HWSubmitResponse hwSubmitResponse = new HWSubmitResponse();
        hwSubmitResponse.setId(hwSubmission.getSubmissionId());
        hwSubmitResponse.setUserId(hwSubmission.getUser().getUserId());
        hwSubmitResponse.setHwId(hwSubmission.getHomeWork().getHomeWorkId());
        return hwSubmitResponse;
    }
}
