package ai.xiao.hui.springcloud.controller;

import ai.xiao.hui.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController {
    @Resource
   private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/order/hystrix/err/{id}")
    public String paymentInfo_Err(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Err(id);
        return result;
    }
}
