package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.WithdrawReqResponse;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.withdrawRequest")
public class WithdrawRequestService implements IService {

    @Override
    public BaseResponseDto<WithdrawReqResponse> handle(String requestData) {
        BaseResponseDto dto = new BaseResponseDto();
        WithdrawReqResponse resp = new WithdrawReqResponse();
        resp.setStatus("100");
        resp.setMessage("提现成功");
        dto.setOperation(resp);
        return dto;
    }
}
