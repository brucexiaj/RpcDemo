package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.LoginResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

/**
 * 登录
 */
@Service("wq.wangqin.login")
public class LoginService implements IService {


    @Override
    public BaseResponseDto<LoginResponseDto> handle(String requestData) {


        return null;
    }
}
