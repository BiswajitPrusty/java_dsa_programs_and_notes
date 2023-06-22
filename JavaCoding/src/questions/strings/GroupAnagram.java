package questions.strings;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(listOfGroupAnagram("eat", "tea", "tan", "ate", "nat", "bat"));
    }

    private static List<List<String>> listOfGroupAnagram(String... arr) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char[] word = arr[i].toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            if (map.containsKey(key)) {
                map.get(key).add(arr[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(arr[i]);
                map.put(key, newList);
            }
        }
        for (Map.Entry<String, List<String>> i : map.entrySet()) {
            list.add(i.getValue());
        }
        return list;
    }

    private static void findListOfAnagram(String[] arr) {
        Map<Integer, List<String>> var = Arrays.stream(arr).collect(Collectors.groupingBy(e -> fun(e)));
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> hm : var.entrySet()) {
            list.add(hm.getValue());
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    private static int fun(String e) {
        int count = 0;
        char[] res = e.toCharArray();
        for (int i = 0; i < res.length; i++) {
            count += res[i];
        }
        return count;
    }
}
