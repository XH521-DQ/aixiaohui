package ai.xiao.hui.springcloud.dao;

import ai.xiao.hui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment p);
    public Payment getPaymentById(@Param("id") Long id);
}
