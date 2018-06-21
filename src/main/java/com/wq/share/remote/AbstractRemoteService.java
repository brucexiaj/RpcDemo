package com.wq.share.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AbstractRemoteService {

    public final static String ERP_REMOTE_URI = "http://localhost:8100";

    @Autowired
    protected RestTemplate restTemplate;

}
