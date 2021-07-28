package boot;


import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.dubbo"})
@EnableAutoConfiguration
//@EnableDubboConfig
public class boot {
    public static void main(String[] args) {
        SpringApplication.run(boot.class, args);
    }
}
