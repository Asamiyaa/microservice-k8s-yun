package boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YangWenjun
 * @date 2021/7/27 15:16
 * @project microservice-k8s
 * @title: TestSleuth
 * @description:
 */
@Component
@Slf4j
public class TestSleuth {
    public void test(){
        log.info("test sleuth");
    }
}
