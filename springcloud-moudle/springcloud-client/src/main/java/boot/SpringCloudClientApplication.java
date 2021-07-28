package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
public class SpringCloudClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class, args);
    }
}