package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author YangWenjun
 * @date 2020/1/3 15:14
 * @project springCloudDemo
 * @title: SpringCloudClientApplication
 * @description:
 * //
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class SpringCloudClient2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClient2Application.class, args);
    }
}