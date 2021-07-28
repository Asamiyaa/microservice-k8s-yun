package com.dubbo;


@RestController
@ResponseBody
@RequestMapping({"/"})
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private UserInfoISV userInfoISV;

    @RequestMapping("/hello")
    public void sayHello() {
        System.out.println("******democonsumer被访问******");
        System.out.println(userInfoISV.sayHello());
    }
}