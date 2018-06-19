package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.StartUpResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.startUp")
public class StartUpService implements IService{


    @Override
    public BaseResponseDto<StartUpResponseDto> handle(String requestData) {


        return null;
    }
}
