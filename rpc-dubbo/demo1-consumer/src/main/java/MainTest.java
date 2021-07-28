/**
 * @author YangWenjun
 * @date 2021/7/26 11:31
 * @project microservice-k8s
 * @title: MainTest
 * @description:
 */
public class MainTest {

    public static void main(String[] args) {

        reverse("abc de");

    }

    private static void reverse(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        System.out.println(stringBuffer.reverse().toString());
    }


}
