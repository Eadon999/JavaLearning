import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args){
        HashMap<String, Object> pars = new HashMap<String, Object>();
        pars.put("count", 1);
        pars.put("filter", 123L);
        System.out.println((pars.get("count")));
        System.out.println(pars.get("filter"));
    }


}
