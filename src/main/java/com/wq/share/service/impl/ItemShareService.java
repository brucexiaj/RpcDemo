package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.ItemShareResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

/**
 * 分享
 */
@Service("wq.wangqin.share")
public class ItemShareService implements IService{

    @Override
    public BaseResponseDto<ItemShareResponseDto> handle(String requestData) {

        return null;
    }

}
