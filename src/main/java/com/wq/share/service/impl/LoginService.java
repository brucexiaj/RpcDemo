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


    /**
     *
     *  third_party_id 是微信用于与用户userId一一对应的字段
     *
     * 1 如果用户属于1个公司，返回companyNo
     * 2 如果用户属于n个公司，返回默认companyNo
     * 3 如果用户暂时没归属，返回错误码 601
     *
     * @param requestData
     * @return
     */
    @Override
    public BaseResponseDto<LoginResponseDto> handle(String requestData) {


        return null;
    }
}
