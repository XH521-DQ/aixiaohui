package ai.xiao.hui.springcloud.service;

import ai.xiao.hui.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
