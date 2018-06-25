package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.login")
public class LoginService extends AbstractService<LoginRequestDto,LoginResponseDto> {

    @Autowired
    private UserRemoteService userRemoteService;

    @Override
    protected BaseResponseDto<LoginResponseDto> exec(BaseRequestDto<LoginRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        //远程调用ERP后台，获取用户
        LoginRequestDto req = requestDto.getOperation();
        if(req == null){
            throw new ApplicationException(ReturnCode.ILLEGAL_ARG_EXCEPTION);
        }
        LoginResponseDto resp  = userRemoteService.getUserInfo(req);
        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<LoginRequestDto> parse(String requestData) {

        BaseRequestDto<LoginRequestDto> requestDto = BaseDto.fromJson(requestData,
                new TypeReference<BaseRequestDto<LoginRequestDto>>(){});

        return requestDto;
    }

    @Override
    protected void validate(BaseRequestDto<LoginRequestDto> requestDto) {
        //TODO
    }
}
