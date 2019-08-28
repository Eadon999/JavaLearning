import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

public class SparkFilterTest {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("FilterTest")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        JavaRDD<Integer> numberRDD = sc.parallelize(numbers);
        System.out.println(numberRDD.collect());
        System.out.println(numberRDD);
        JavaRDD<Integer> resultRDD = numberRDD.filter(
                new Function<Integer, Boolean>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Boolean call(Integer num) throws Exception {
                        return num % 2 == 0;
                    }
                });

        resultRDD.foreach(new VoidFunction<Integer>() {
            private static final long serialVersionUID = 1L;

            @Override
            public void call(Integer res) throws Exception {
                System.out.println(res);
            }
        });

        sc.close();

    }

}