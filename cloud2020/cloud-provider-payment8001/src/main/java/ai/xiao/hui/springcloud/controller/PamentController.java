package ai.xiao.hui.springcloud.controller;

import ai.xiao.hui.springcloud.entities.CommonResult;
import ai.xiao.hui.springcloud.entities.Payment;
import ai.xiao.hui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PamentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果：{result}");
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：{payment}");
        if(payment!=null){
            return new CommonResult(200,"查询成功 serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"无记录 serverPort:"+serverPort);
        }
    }

    @GetMapping("/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        StringBuffer msg=new StringBuffer();
        services.forEach(service->{
            msg.append(service);
            msg.append("-->");
            log.info("----service"+service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            msg.append(instance.getServiceId()+"\t" + instance.getHost()+"\t"+ instance.getPort()+"\t"+instance.getUri());
            msg.append("-->");
            log.info(instance.getServiceId()+"\t" + instance.getHost()+"\t"+ instance.getPort()+"\t"+instance.getUri());;
        }
        return new CommonResult(200,msg.toString());
    }
}
