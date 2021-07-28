package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author YangWenjun
 * @date 2020/1/3 15:00
 * @project springCloudDemo
 * @title: SpringCloudEurekaApplication
 * @description:
 */
    @EnableEurekaServer
    @SpringBootApplication
    public class SpringCloudEurekaApplication {
        public static void main(String[] args) {
            SpringApplication.run(SpringCloudEurekaApplication.class, args);
        }
    }

