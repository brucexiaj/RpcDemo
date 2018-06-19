package com.wq.share.service.impl;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;
import com.wq.share.remote.UserRemoteService;
import com.wq.share.remote.dto.AuthUserDO;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录
 */
@Service("wq.wangqin.login")
public class LoginService implements IService {


    @Autowired
    private UserRemoteService userRemoteService;


    /**
     *
     *  third_party_id 是微信用于与用户userId一一对应的字段
     *
     *  返回
     *  a userId
     *  b companyNo
     *    1 如果用户属于1个公司，返回companyNo
     *    2 如果用户属于n个公司，返回默认companyNo
     *    3 如果用户暂时没归属，返回错误码 601
     *
     * @param requestData
     * @return
     */
    @Override
    public BaseResponseDto<LoginResponseDto> handle(String requestData) {

        //1 反序列化
        BaseRequestDto<LoginRequestDto> requestDto = BaseDto.fromJson(requestData, BaseRequestDto.class);
        BaseResponseDto responseDto = new BaseResponseDto();

        //远程调用ERP后台，获取用户
        LoginRequestDto req = requestDto.getOperation();
        AuthUserDO userDO = userRemoteService.getUserInfo(req);
        LoginResponseDto resp = new LoginResponseDto();
        resp.setCompanyNo(userDO.getCompanyNo());
        resp.setUserNick(userDO.getName());
        resp.setUserId(userDO.getUserNo());
        responseDto.setOperation(resp);

        return responseDto;
    }
}
