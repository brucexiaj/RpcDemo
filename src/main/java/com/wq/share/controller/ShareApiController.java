package com.wq.share.controller;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.common.Constants;
import com.wq.share.common.SpringContextUtil;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
import com.wq.share.service.IService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

@Controller
@RequestMapping("/api/")
@Slf4j
public class ShareApiController {

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    @ResponseBody
    public String postService(@RequestBody String data){
        String methodApi = "";
        String requestData = "";
        BaseResponseDto responseDto = new BaseResponseDto();

        try {
            Request req = parseRequest(data);
            methodApi = req.getMethodApi();
            requestData = req.getRequestData();

            log.info("===> receive request on {}, request data is {}", methodApi, requestData);
            //1 查询处理Service
            ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
            IService apiService = applicationContext.getBean(methodApi, IService.class);
            if (apiService == null){
                throw new ApplicationException(ReturnCode.NOT_FOUND_EXCEPTION);
            }
            //2 触发调用
            responseDto = apiService.handle(requestData);
        }catch (IllegalArgumentException illExp){
            log.error("===> request method: {}, request data: {}, illegal argument exception: ", methodApi, requestData, illExp);
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

    private Request parseRequest(@RequestBody String data) throws Exception {

        if (StringUtils.isBlank(data)){
            throw new ApplicationException(ReturnCode.ILLEGAL_ARG_EXCEPTION);
        }
        String dataReq = URLDecoder.decode(data, Constants.UTF8);
        //TODO 待研究, 为什么多了一个=
        if(dataReq.endsWith("=")){
            dataReq = dataReq.substring(0, dataReq.length()-1);
        }
        return BaseDto.fromJson(dataReq, Request.class);
    }

    /**
     * for local test mock
     * @param requestData
     * @param methodApi
     * @return
     */
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @ResponseBody
    public String apiService(@RequestParam(name="requestData") String requestData, @RequestParam("methodApi") String methodApi){
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


    @Getter
    @Setter
    public static class Request{
        String methodApi;
        String requestData;

        public String getMethodApi(){
            return StringUtils.isBlank(this.methodApi)? "": this.methodApi.trim();
        }

        public String getRequestData(){
            return StringUtils.isBlank(this.requestData)? "": this.requestData.trim();
        }

    }

}
