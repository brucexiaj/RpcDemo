package com.wq.share.service.impl;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.TestRequstDto;
import com.wq.share.enums.ReturnCode;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("wq.wangqin.test")
public class TestService implements IService {
    @Override
    public BaseResponseDto handle(String requestData) {

        BaseResponseDto responseDto = new BaseResponseDto();

        BaseRequestDto<TestRequstDto> requestDto = BaseDto.fromJson(requestData, BaseRequestDto.class);

        //build default response data;
        Map<String, String> result = new HashMap<>();
        result.put("testKey", "testValue");

        //build default response common data
        BaseResponseDto.Common common = new BaseResponseDto.Common();
        common.setStatus(ReturnCode.SUCCESS.getCode());
        common.setMessage(ReturnCode.SUCCESS.getMessage());
        common.setCookie(requestDto.getCommon().getCookie());

        responseDto.setCommon(common);
        responseDto.setOperation(result);


        return responseDto;
    }
}
