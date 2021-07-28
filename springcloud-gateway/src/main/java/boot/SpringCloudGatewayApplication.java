package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YangWenjun
 * @date 2020/1/3 15:00
 * @project springCloudDemo
 * @title: SpringCloudEurekaApplication
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }
}

