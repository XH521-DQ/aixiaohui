package ai.xiao.hui.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator gatewayLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_aixiaohui",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

//    public static void main(String[] args) {
//        ZonedDateTime dateTime= ZonedDateTime.now();
//        System.out.println(dateTime);
//    }
}
