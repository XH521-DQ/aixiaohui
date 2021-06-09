package ai.xiao.hui.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_Err(Integer id);
}
