package ai.xiao.hui.springcloud.service.healthReturn;

import ai.xiao.hui.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 失败";
    }

    @Override
    public String paymentInfo_Err(Integer id) {
        return "paymentInfo_Err 失败";
    }
}
