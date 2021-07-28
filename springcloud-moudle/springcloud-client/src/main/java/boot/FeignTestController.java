package boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangWenjun
 * @date 2021/7/27 9:53
 * @project microservice-k8s
 * @title: FeignTestController
 * @description:
 */
@RestController
@RequestMapping("/test/feign")
@Slf4j
public class FeignTestController {
    @GetMapping()
    public String getUser(){
        Map result = new HashMap();
        result.put("name", "xiaoming");
        result.put("sex", "male");
        result.put("age", 12);
        System.out.println("==> feign call ==>");
        log.info("this is client call");
        return result.toString();
    }
}