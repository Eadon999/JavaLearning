import java.util.Arrays;
import java.util.List;

import static org.spark_project.guava.collect.Collections2.filter;


public class TestLambda {
    public static void main(String args[]) {


        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which starts with S :");
        languages.stream().filter(str -> str.contains("S"));

        System.out.println("Languages which ends with a ");
        filter(languages, str -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

//        System.out.println("Print language whose length greater than 4:");
//        filter((str) -> str.length() > 4);

    }

}
