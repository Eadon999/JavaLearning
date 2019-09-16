import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testArrayList {
    public static void main(String[] args) {
        String[] data = {"1", "2", "3", "4", "5"};
        double[] nums = new double[5];
        for (double i : nums) {
            System.out.print(i);
        }
//        System.out.print(data);
        System.out.print(getType(data));
        List list = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print(list);
    }

    public static String getType(Object o) { //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }


}
