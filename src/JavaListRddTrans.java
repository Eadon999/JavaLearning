/**
 * java中普通list利用spark的reduce计算
 */

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;


public class JavaListRddTrans {
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder().appName("JavaWordCount").master("local").getOrCreate();
        //spark对普通List的reduce操作
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> originRDD = javaSparkContext.parallelize(data);

        Integer sum = originRDD.reduce((a, b) -> a + b);
        Integer sum2 = originRDD.reduce(
                new Function2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                });
        System.out.println(sum);
        System.out.println(sum2);

        //reduceByKey，按照相同的key进行reduce操作
        List<String> list = Arrays.asList("key1", "key1", "key2", "key2", "key3");
        JavaRDD<String> stringRDD = javaSparkContext.parallelize(list);
        //转为key-value形式
        JavaPairRDD<String, Integer> pairRDD = stringRDD.mapToPair(k -> new Tuple2<String, Integer>(k, 1));
        List list1 = pairRDD.reduceByKey((x, y) -> x + y).collect();
        System.out.println(list1);
    }
}
