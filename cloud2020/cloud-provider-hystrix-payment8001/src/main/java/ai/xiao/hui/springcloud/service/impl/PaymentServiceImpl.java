package ai.xiao.hui.springcloud.service.impl;

import ai.xiao.hui.springcloud.service.PaymentService;

import java.util.concurrent.TimeUnit;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id"+id;
    }

    @Override
    public String paymentInfo_Err(Integer id) {
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Err,id"+id+"耗时"+timeNumber+"秒钟";
    }
}
