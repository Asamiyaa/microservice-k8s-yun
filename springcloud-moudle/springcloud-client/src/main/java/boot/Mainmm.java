package boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author： wb_yangwenjun@meituan.com
 * @Date: 2021/7/15 10:56 上午
 */
public class Mainmm {

    public static void main(String[] args) {
        double[] doubleArray = new double[]{0,1, 2, 3};

//        double[] ret1 = powFor(doubleArray);
//        System.out.println(Arrays.toString(ret1));

//        double[] ret2 = powStream(doubleArray);
//        System.out.println(Arrays.toString(ret2));

//        double[] ret3 = firstClass(doubleArray);
//        System.out.println(Arrays.toString(ret3));

//        immutable();

//        pure();
//        multiList();

        lazy();

    }

    private static double[] powFor(double[] doubleArray) {

        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Math.pow(doubleArray[i],2);
        }

        return doubleArray;
    }

    private static double[] powStream(double[] doubleArray) {

        return Arrays.stream(doubleArray).map(x -> Math.pow(x, 2)).toArray();
    }

    /**
     * first-class
     */
    private static double[] firstClass(double[] doubleArray) {

        DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double operand) {
                return Math.pow(operand,2);
            }
        };

        return Arrays.stream(doubleArray).map(doubleUnaryOperator).toArray();
    }

    /**
     * immutable
     */
    private static void immutable(){

        List<String> list = Arrays.asList("a");
        list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1);
        list1.stream().map(x -> x+1).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * pure
     */
    private static double w = 0.1;
    private static void pure(){
        double percent = 0.5;
        double money = 100;
        BiFunction<Double,Double,Double> biFunction = (a,b) -> {
            return a * b * w;
        };
        System.out.println(biFunction.apply(money, percent));

        MyFunction myFunction = (a,b,w) -> {
            return a * b * w;
        };
        System.out.println(myFunction.method(money, percent, 0.1));

    }

    /**
     * multiList
     */
    private static void multiList(){
        // filter - map - group by - sort - limit 1;
        List<String> ll = Arrays.asList("1","aC","aB");

        System.out.println(ll.stream().filter(x -> x.startsWith("a")).map(String::toLowerCase).sorted().limit(1).findFirst().get());

        List l = new ArrayList();
        for (String s : ll) {
            if(!s.startsWith("a")) continue;
            l.add(s.toLowerCase());
        }
        Collections.sort(l);
        System.out.println(l.get(0));
    }

    /**
     * lazy
     */
    private static void lazy(){
        List<String> names = Arrays.asList("Brad","kate","Kim");
        Stream<String> namesWith3Letters = names.stream()
                .filter(name -> length(name)== 3)
                .map(name -> toUpper(name));

        System.out.println("Stream created, filtered, mapped...");
        System.out.println("ready to call findFirst...");

        final String firstNameWith3Letters = namesWith3Letters.findFirst().get();

        System.out.println(firstNameWith3Letters);

    }
    private static int length(final String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }
    private static String toUpper(final String name ) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }



    /**
     * https://www.runoob.com/java/java8-functional-interfaces.html
     */
//    private static void pureTest1(double d1,double d2,BiFunction biFunction){
//        System.out.println(biFunction.apply(d1, d2));
//    }

}


@FunctionalInterface
interface MyFunction  {
    double method(double d1,double d2, double d3);
}