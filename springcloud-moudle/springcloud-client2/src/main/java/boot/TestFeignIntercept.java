package boot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author YangWenjun
 * @date 2021/7/27 9:47
 * @project microservice-k8s
 * @title: TestFeignIntercept
 * @description: 类似于thrift中代理类、配置了appkey 根据对应方法进行
 */
@FeignClient(value = "springcloud-client",name = "springcloud-client") //指向注册名为springcloud-client的服务
public interface TestFeignIntercept {
    /**
     * 内部接口，获取信息
     * @return
     */
    @GetMapping("/test/feign") //指向springcloud-client中接口路径为/feign/test的接口
    String getFeignMassage();
}