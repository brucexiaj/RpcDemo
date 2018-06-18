package com.wq.share.controller;

import com.wq.share.common.BaseDto;
import com.wq.share.remote.TestRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private TestRemoteService testRemoteService;

    @RequestMapping("/api/test")
    @ResponseBody
    public String test(){
        Map<String, String> result = new HashMap<>();
        result.put("testKey","testValue");
        return BaseDto.toString(result);
    }

    @RequestMapping("/api/remote/test")
    @ResponseBody
    public String mockRemoteCall(){
        String result = testRemoteService.remoteCall();
        return result;
    }



}
