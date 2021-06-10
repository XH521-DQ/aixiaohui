package ai.xiao.hui.springcloud.service;

public interface PaymentService {
     String paymentInfo_OK(Integer id);
     String paymentInfo_Err(Integer id);
     String paymentInfo_Break(Integer id);
}
