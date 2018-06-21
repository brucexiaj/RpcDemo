package com.wq.share;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class OneShareApplicationConfig {

    @Value("${erp.remote.address}")
    private String erpRemoteURI;

}
