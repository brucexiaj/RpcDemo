package com.wq.share.controller;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.common.SpringContextUtil;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
import com.wq.share.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/")
@Slf4j
public class ShareApiController {

    @RequestMapping("/service")
    @ResponseBody
    public String apiService(@RequestParam(name="requestData") String requestData, @RequestParam("method_api") String methodApi){
        log.info("===> receive request on {}, request data is {}", methodApi, requestData);
        BaseResponseDto responseDto = new BaseResponseDto();
        try {
            //1 查询处理Service
            ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
            IService apiService = applicationContext.getBean(methodApi, IService.class);
            if (apiService == null){
                throw new ApplicationException(ReturnCode.NOT_FOUND_EXCEPTION);
            }
            //2 触发调用
            responseDto = apiService.handle(requestData);
        }catch (IllegalArgumentException illExp){
            log.error("===> request method: {}, request data: {}, illegal argument exception: {}", methodApi, requestData, illExp);
            responseDto = responseDto.buildError(ReturnCode.ILLEGAL_ARG_EXCEPTION);
        }catch (ApplicationException ae) {
            String expMsg = String.format("%s-%s", ae.getType().getCode(), ae.getMessage());
            log.error("===> request method: {}, request data: {}, application exception: {}", methodApi, requestData, expMsg);
            responseDto = responseDto.buildError(ae);
        } catch (Exception e){
            log.error("===> request method: {}, request data: {}, sys exception: {}", methodApi, requestData, e);
            responseDto = BaseResponseDto.buildSystemError();
        }
        String result = BaseDto.toString(responseDto);
        log.info("===> request method: {}, request data: {}, response: {}", methodApi, requestData, result);
        return result;
    }

}
