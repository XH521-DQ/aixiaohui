package ai.xiao.hui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentClMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentClMain8006.class,args);
    }
}
