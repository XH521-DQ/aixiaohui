package ai.xiao.hui.springcloud.controller;

import ai.xiao.hui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/hystrix/err/{id}")
    public String paymentInfo_Err(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Err(id);
        log.info(result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/hystrix/break/{id}")
    public String paymentInfo_Break(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Break(id);
        log.info(result);
        return result;
    }

}
