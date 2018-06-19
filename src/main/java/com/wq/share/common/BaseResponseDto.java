package com.wq.share.common;

import com.wq.share.common.exception.ApplicationException;
import com.wq.share.common.exception.BaseReturnType;
import com.wq.share.enums.ReturnCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

@Slf4j
@Getter
@Setter
public class BaseResponseDto<T> {

    private T operation;

    private Common common = new Common();

    @Getter
    @Setter
    public static class Common{
        private String status = ReturnCode.SUCCESS.getCode();
        private String message;
//        private String cookie;
    }

    public static BaseResponseDto<String> buildError(ApplicationException ae){
        BaseResponseDto<String> responseDto = new BaseResponseDto<>();
        BaseResponseDto.Common common = new BaseResponseDto.Common();
        common.setStatus(ae.getType().getCode());
        common.setMessage(ae.getMessage());
        responseDto.setCommon(common);
        return responseDto;
    }

    public static BaseResponseDto<String> buildError(BaseReturnType returnType, Object... args){
        return buildError(new ApplicationException(returnType, args));
    }

    public static BaseResponseDto<String> buildSystemError(){
        return buildError(ReturnCode.SYSTEM_EXCEPTION);
    }

}
