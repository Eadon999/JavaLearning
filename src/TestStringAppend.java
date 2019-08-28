import java.util.*;

public class TestStringAppend {
    public static void main(String[] args){
        StringBuilder filter = new StringBuilder();
        filter.append("test");
        filter.append("AND NOT tet");
        String filterStr = filter.toString();
        System.out.println(filterStr);
    }
}
