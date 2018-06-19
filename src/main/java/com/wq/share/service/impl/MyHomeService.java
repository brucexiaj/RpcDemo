package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

/**
 * 我的页面
 */
@Service("wq.wangqin.myHome")
public class MyHomeService implements IService {
    @Override
    public BaseResponseDto<MyHomeResponseDto> handle(String requestData) {
        return null;
    }
}
