package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.WithdrawListRequestDto;
import com.wq.share.dto.response.WithdrawListResponse;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.withdrawList")
public class WithdrawListService extends AbstractService<WithdrawListRequestDto,WithdrawListResponse> {

    @Override
    protected BaseResponseDto<WithdrawListResponse> exec(BaseRequestDto<WithdrawListRequestDto> requestDto) {

        //TODO implement on the way
        BaseResponseDto<WithdrawListResponse> responseDto = new BaseResponseDto<>();
        WithdrawListResponse response = new WithdrawListResponse();
        responseDto.setOperation(response);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<WithdrawListRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<WithdrawListRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<WithdrawListRequestDto> requestDto) {
        //TODO
    }
}
