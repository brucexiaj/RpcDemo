package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.WithdrawListResponse;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.withdrawList")
public class WithdrawListService implements IService {

    @Override
    public BaseResponseDto<WithdrawListResponse> handle(String requestData) {

        BaseResponseDto<WithdrawListResponse> responseDto = new BaseResponseDto<WithdrawListResponse>();
        WithdrawListResponse response = new WithdrawListResponse();
        responseDto.setOperation(response);

        return null;
    }
}
