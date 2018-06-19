package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.GoodsSearchResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.search")
public class GoodsSearchService implements IService {

    @Override
    public BaseResponseDto<GoodsSearchResponseDto> handle(String requestData) {

        return null;
    }
}
