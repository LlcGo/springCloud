package springcloud.service;


import com.lc.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
