package boot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author YangWenjun
 * @date 2020/1/3 15:59'
 *    放到和启动类同一路径下才能正常加载扫描到
 */
@RestController
@RefreshScope
@RequestMapping("/client")
public class TestController {
    @Value("${user.name}") //获取配置文件中对应属性的值
    private String userName;

    @GetMapping("/getName")
    public String getUserName(){
        return userName;
    }

    @PostMapping("/postName")
    public String postName(@RequestBody Map<String,String> param){
        return param.get("name");
    }
}
