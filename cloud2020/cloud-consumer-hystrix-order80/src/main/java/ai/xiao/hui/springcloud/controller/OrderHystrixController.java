package ai.xiao.hui.springcloud.controller;

import ai.xiao.hui.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
/*@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")*/
public class OrderHystrixController {
    @Resource
   private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/order/hystrix/err/{id}")
   /* @HystrixCommand(fallbackMethod = "orderInfo_ErrHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    //@HystrixCommand
    public String paymentInfo_Err(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Err(id);
        return result;
    }

    public String orderInfo_ErrHandler(Integer id){
        return "orderInfo_ErrHandler:请求超时";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理";
    }
}
