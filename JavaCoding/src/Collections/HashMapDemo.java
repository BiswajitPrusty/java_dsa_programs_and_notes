package Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> fruits = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(10);

        Set<Integer> d = (Set<Integer>) set.clone();

        System.out.println(d+" set ");
        fruits.put(1, "Mango");
        fruits.put(2, "Apple");
        fruits.put(3, "Banana");
        fruits.put(4, "Grapes");
        System.out.println(fruits);
//        for(Map.Entry m : fruits.entrySet())
//            System.out.println(m.getKey()+" = "+m.getValue());

        for (Map.Entry data : fruits.entrySet())
            System.out.println(data.getKey() + " " + data.getValue());

        Map<Integer, String> vegi = new HashMap<>();
        System.out.println(fruits.get(1)
        );

        vegi.put(5, "Potato");
        vegi.put(6, "Tomato");
        vegi.put(7, "Carrot");
        vegi.put(8, "chilly");
        System.out.println(vegi);
        fruits.putAll(vegi);// this methods adds all the key value pairs of specified map into invoked map
//        fruits.remove(8);
//        fruits.remove(7,"Carrot");
        fruits.replace(8, "Beans");
        System.out.println(fruits);
    }
}
