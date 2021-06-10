package ai.xiao.hui.springcloud.service.impl;
import ai.xiao.hui.springcloud.service.PaymentService;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_ErrHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Err(Integer id) {
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Err,id"+id+"耗时"+timeNumber+"秒钟";
    }
    //服务降级
    public String paymentInfo_ErrHandler(Integer id){
        return "paymentInfo_ErrHandler:请求超时";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_Break_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentInfo_Break(Integer id){
        if(id<0){
            throw new RuntimeException("********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID().toString();
        return Thread.currentThread().getName()+"\t 调用成功，流水号："+serialNumber;
    }

    public String paymentInfo_Break_fallback(@PathVariable("id") Integer id){
        return "Id 不能负数，请稍后再试，o(╥﹏╥)o id:"+id;
    }

}
