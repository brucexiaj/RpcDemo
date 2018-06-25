package com.wq.share.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wq.share.common.BaseDto;

@Controller
public class TestController {

    @RequestMapping("/api/test")
    @ResponseBody
    public String test() {
        Map<String, String> result = new HashMap<>();
        result.put("testKey", "testValue");
        return BaseDto.toString(result);
    }

}
