package com.wq.share.service.impl;

import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.dto.request.AbstractRequestDto;
import com.wq.share.dto.response.AbstractResponseDto;
import com.wq.share.enums.ReturnCode;
import com.wq.share.service.IService;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractService<T extends AbstractRequestDto, K extends  AbstractResponseDto> implements IService {

    @Override
    public final BaseResponseDto<K> handle(String requestData) {

        if (StringUtils.isBlank(requestData)){
            throw new ApplicationException(ReturnCode.ILLEGAL_ARG_EXCEPTION);
        }
        BaseRequestDto<T> requestDto = parse(requestData);
        validate(requestDto);
        BaseResponseDto<K> responseDto = exec(requestDto);
        return responseDto;
    }

    /**
     * 执行API操作
     * @param requestDto
     * @return
     */
    protected abstract BaseResponseDto<K> exec(BaseRequestDto<T> requestDto);


    /**
     * 解析参数
     * @param requestData
     * @return
     */
    protected abstract BaseRequestDto<T> parse(String requestData);

    /**
     * 校验参数
     * @param requestDto
     */
    protected abstract void validate(BaseRequestDto<T> requestDto);

}
