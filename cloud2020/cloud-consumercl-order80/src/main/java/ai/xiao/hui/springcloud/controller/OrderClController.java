package ai.xiao.hui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderClController {
    private static final String PAYMENT_CL_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/payment/cl")
    public String getProviderZkUrl(){
        String result=restTemplate.getForObject(PAYMENT_CL_URL+"/payment/cl",String.class);
        return result;
    }
}
