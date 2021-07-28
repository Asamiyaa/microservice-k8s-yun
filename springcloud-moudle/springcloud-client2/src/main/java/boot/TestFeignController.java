package boot;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author YangWenjun
 * @date 2020/1/3 15:59'
 *    放到和启动类同一路径下才能正常加载扫描到
 */

@RestController
@RequestMapping("/testFeign")
@Slf4j
public class TestFeignController {
    @Autowired
    private TestFeignIntercept testFeignIntercept; // 服务端没有对应实现时,编写报没有对应实例 - 如何mock? - 修改级别：https://www.cnblogs.com/panchanggui/p/12503690.html
    /**
     * 获取信息
     * @return
     */
    @GetMapping
    public String getFeignMessage(){
        System.out.println("==>local==>");
        return this.testFeignIntercept.getFeignMassage();
    }

    /**
     * 熔断器的应用场景是有进行服务之间的调用。这里使用feign调用weather服务，所以这里如果无法访问
     * weather的getDataParam服务的时候，就启动熔断器，调用反馈方法fallback
     * @param city
     * @return
     */

    @Autowired
    TestSleuth sleuth;

    @HystrixCommand(fallbackMethod="fallback")
    @RequestMapping("/{city}")
    public String getDataParam(@PathVariable("city")String city){
        log.info("this is invocker");
        sleuth.test();
        return this.testFeignIntercept.getFeignMassage() +" <===> "+ city;
    }

    public String fallback(String city){
        return "services is not running! parameters city is:"+city;
    }

    @RequestMapping("/load/{city}")
    @LoadBalanced // 测试负载均衡
    public String testLoad(@PathVariable("city")String city){
        return this.testFeignIntercept.getFeignMassage() +" <===> "+ city;
    }

}
