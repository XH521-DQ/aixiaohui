package ai.xiao.hui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {
    public static final String PROVIDER_ZK_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/payment/zk")
    public String getProviderZkUrl(){
        String result=restTemplate.getForObject(PROVIDER_ZK_URL+"/payment/zk",String.class);
        return result;
    }
}
