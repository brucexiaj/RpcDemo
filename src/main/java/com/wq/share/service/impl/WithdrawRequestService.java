package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.WithdrawReqRequestDto;
import com.wq.share.dto.response.WithdrawReqResponse;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.withdrawRequest")
public class WithdrawRequestService extends AbstractService<WithdrawReqRequestDto,WithdrawReqResponse> {


    @Override
    protected BaseResponseDto<WithdrawReqResponse> exec(BaseRequestDto<WithdrawReqRequestDto> requestDto) {
        BaseResponseDto dto = new BaseResponseDto();
        WithdrawReqResponse resp = new WithdrawReqResponse();
        resp.setStatus("100");
        resp.setMessage("提现成功");
        dto.setOperation(resp);
        return dto;
    }

    @Override
    protected BaseRequestDto<WithdrawReqRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<WithdrawReqRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<WithdrawReqRequestDto> requestDto) {
        //TODO
    }
}
