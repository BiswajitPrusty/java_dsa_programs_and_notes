package javaeight;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsGroupBy {
    public static void main(String[] args) {
        findFirstRepeatedChar("staatic");
        getEmployHighSalaryFromEveryDept();
//        skipAndLimitUseCase();
    }

    public static void skipAndLimitUseCase() {
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);
    }

    public static void stringJoinMethod() {
        String[] s = "How are you doing?".split(" ");

        String joinedString = String.join(",", s);
        System.out.println(joinedString);
    }

    public static void printNumbStartingWithOne() {
        int arr[] = {3, 4, 11, 1, 7, 5, 6, 9, 2};
        List<String> collect = Arrays.stream(arr)
                .boxed()
                .map(s -> s.toString())
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    public static void findLongestString() {
        String[] s = "How are you doing?".split(" ");
        String longestString = Arrays.stream(s)
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .get();
        System.out.println(longestString);
    }

    public static void findSecondHighest() {

        int arr[] = {3, 4, 1, 7, 5, 6, 9, 2};

        //easy way
        Integer secondHighValue = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println();
        System.out.println(secondHighValue);
    }

    public static void findFirstRepeatedChar(String s) {
        String firstRepeatedChar = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(kv -> kv.getValue() > 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(firstRepeatedChar);

    }

    public static void findFirstNonRepeatChar(String s) {
        String key = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(keyValue -> keyValue.getValue() == 1)
                .findFirst()
                .get().getKey();

        System.out.println("first non repeat character " + key);
    }

    public static void findUniqueElementsFromString(String s) {
        List<String> uniqueElementsInString = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(keyValue -> keyValue.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniqueElementsInString);
    }

    public static void findAllDuplicateElementFromString(String s) {
        Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(keyValue -> keyValue.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void countOccurrence(String line) {

        Map<String, Long> countMap = Arrays.stream(line.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);
    }

    public static void groupByCountSameNames() {
        Map<String, Long> collect = Arrays.asList("sunil", "biswa", "ram", "ram")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    public static void getEmployHighSalaryFromEveryDept() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jack", 2000, "DEV"),
                new Employee(2, "Chris", 2000, "UAT"),
                new Employee(3, "Anna", 2000, "QA"),
                new Employee(4, "Venkat", 4000, "DEV")

        );
        //first way easy to understand
        Map<String, Optional<Employee>> empWithMaxSalary = employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept,
                                Collectors
                                        .reducing(BinaryOperator.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())))));
        System.out.println(empWithMaxSalary);

        Map<String, Employee> employeeMap2 = employees.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
        System.out.println(employeeMap2);
    }
}
