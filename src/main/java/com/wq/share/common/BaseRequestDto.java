package com.wq.share.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseRequestDto<T> {

    private BaseRequestDto.Device device;
    private BaseRequestDto.Common common;
    private T operation;

    @Setter
    @Getter
    public static class Device{
        private String model;
        private String os;
        private String device_id;
        private String device_root;
    }

    @Getter
    @Setter
    public static class Common{
        private String cookie;
        private String productId;
        private String channel;
        private String pushToken;
        private String ua;
        private String time;
        private String userId;
        private String productVersion;
        private String idfa;
        private String companyNo;

    }


}
