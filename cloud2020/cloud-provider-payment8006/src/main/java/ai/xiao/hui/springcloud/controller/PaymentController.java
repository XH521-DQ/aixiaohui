package ai.xiao.hui.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/payment/cl")
    public String paymentzk(){
        return "springcloud with consul "+serverPort;
    }

}
