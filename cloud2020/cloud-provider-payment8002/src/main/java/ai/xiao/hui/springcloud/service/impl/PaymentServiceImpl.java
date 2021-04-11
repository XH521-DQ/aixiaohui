package ai.xiao.hui.springcloud.service.impl;

import ai.xiao.hui.springcloud.dao.PaymentDao;
import ai.xiao.hui.springcloud.entities.Payment;
import ai.xiao.hui.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    public int create(Payment p){
       return  paymentDao.create(p);
    };

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    };
}
