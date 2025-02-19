package javaeight;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamApi {
    static List<Integer> nums = List.of(1, 2, 8, 19, 3, 4, 4, 5, 6);
    static List<String> strings = List.of("cherry", "banana", "tomatos", "pumkin");
    static List<Employee> employees = List.of(
            new Employee(1, "Jack", 2000, "DEV"),
            new Employee(2, "Chris", 2000, "UAT"),
            new Employee(3, "Anna", 2000, "QA"),
            new Employee(4, "Venkat", 1000, "DEV")

    );

    public static void main(String[] args) {

        System.out.println(
                strings.stream()
                        .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Comparator.comparingLong(kv -> kv.getValue()))
                        .get()
                        .getKey()
        );

        String sentence = "Java is fun and Java is powerful";
        findMinNumber();

        System.out.println(
                IntStream.rangeClosed(1, 4)
                        .reduce(1, (a, b) -> a * b)
        );

        System.out.println(
                nums.stream()
                        .collect(Collectors.partitioningBy(num -> isPrime(num)))
        );

        System.out.println(
                nums.stream()
                        .filter(n -> Collections.frequency(nums, n) > 1)
                        .collect(Collectors.toSet())

        );

        System.out.println(
                nums.stream()
                        .max(Comparator.comparingInt(e -> e))
                        .get()
        );

        System.out.println(
                strings.stream()
//                .sorted(Comparator.comparingInt(e -> e.length()))
                        .max(Comparator.comparingInt(s -> s.length()))
                        .get()
        );

        System.out.println(
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))

        );
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10).map(f -> f[0] + ",").forEach(System.out::print);
//        findMinNumber();
        String input = "aswwiss";

        System.out.println(
                nums.stream()
                        .mapToInt(Integer::intValue)
                        .sum()

        );
        System.out.println(
                nums.stream()
                        .allMatch(n -> n > 2)

        );
        System.out.println(
                Stream.iterate(0, n -> n + 2)
                        .limit(5)
                        .collect(Collectors.toList())
        );
        System.out.println(
                nums.stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .get()

        );
        System.out.println(
                nums.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0))
        );

        System.out.println(
                strings.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())
        );

        System.out.println(
                nums.stream()
                        .filter(n -> n > 2)
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList())
        );

        System.out.println(
                nums.stream()
                        .filter(n -> n % 2 == 0)
                        .findFirst()
                        .get()
        );

        System.out.println(
                input.chars()
                        .mapToObj(c -> (char) c)
                        .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                        .findFirst()
                        .orElse(null)
        );

        System.out.println(
                employees.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary)
                                .reversed())
                        .collect(Collectors.toList())
        );

        System.out.println(
                strings.stream()
                        .collect(Collectors.groupingBy(str -> str, Collectors.counting())
                        ));
        System.out.println(
                nums.stream()
                        .reduce(0, Integer::sum)

        );
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))

        );

        System.out.println(employees.stream().
                filter(e -> e.getDept().equalsIgnoreCase("DEV"))
                .map(e -> e.getSalary())
                .mapToDouble(Double::doubleValue)
                .sum()

        );
    }

    public static void findMinNumber() {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 15);
        int min = numbers.stream().min(Comparator.comparingInt(e ->e)).orElseThrow(() ->
                new RuntimeException("No minimum value found"));
        System.out.println(min);
    }

    public static void flatMap() {
        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8));
        List<Integer> collect = lists.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void sortCollection() {
        ArrayList<Employee> employees1 = new ArrayList<>(employees);
        Set<Integer> collect1 = nums.stream().collect(Collectors.toSet());
        System.out.println(collect1);
        Collections.sort(employees1, Comparator.comparing(Employee::getName));
        List<Employee> collect = employees1.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }


    public static void average() {
        double asDouble = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(asDouble);
    }

    public static void concatString() {
        String collect = strings.stream().collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    public static void startsWith() {
        long countOfSameStart = strings.stream()
                .filter(s -> s.startsWith("c"))
                .count();
        System.out.println(countOfSameStart);
    }

    public static void findMaximumElement() {
        Integer maxNumb = nums.stream().max(Comparator.comparingInt(e -> e)).get();
        System.out.println(maxNumb);
    }


    public static void moveZerosToLast() {
        List<Integer> collect = Stream.concat(nums.stream().filter(n -> n != 0), nums.stream().filter(n -> n == 0))
                .collect(Collectors.toList());
        System.out.println(collect);
    }


    public static void sumOfAllElements() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int sum = nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

    }


    public static void longestStringFromArray(String[] str) {
        String longestString = Arrays.stream(str)
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .get();
        System.out.println(longestString);

    }

    public static void findDuplicateElements(String s) {
        List<String> collect = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(kv -> kv.getValue() > 1)
                .map(kv -> kv.getKey())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void countOfCharOccurance(String s) {
        Map<String, Long> collect = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }

    public static void getMaximumCount(String s) {
        String key = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(kv -> kv.getValue()))
                .get()
                .getKey();

        System.out.println(key);

    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(n -> num % n == 0);
    }
}
