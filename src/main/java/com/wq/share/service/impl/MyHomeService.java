package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.MyHomeRequestDto;
import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.remote.OrderRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 我的页面
 */
@Service("wq.wangqin.myHome")
public class MyHomeService extends AbstractService<MyHomeRequestDto, MyHomeResponseDto> {

    @Autowired
    private OrderRemoteService orderRemoteService;

    @Override
    protected BaseResponseDto<MyHomeResponseDto> exec(BaseRequestDto<MyHomeRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        MyHomeRequestDto req = requestDto.getOperation();
        MyHomeResponseDto resp = orderRemoteService.getMyHomeList(requestDto.getCommon().getUserId(),
                req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<MyHomeRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<MyHomeRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<MyHomeRequestDto> requestDto) {
        //TODO
    }
}
