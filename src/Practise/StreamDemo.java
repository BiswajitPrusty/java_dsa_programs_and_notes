package Practise;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(15);
        a.add(5);
        a.add(7);
        List<Integer> even = a.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        List<Integer> doubleList = a.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(a + " " + even + " doubled" + doubleList);
    }
}
