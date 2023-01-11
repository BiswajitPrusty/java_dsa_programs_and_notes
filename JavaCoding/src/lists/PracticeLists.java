package lists;

import java.util.*;
import java.util.stream.Stream;

public class PracticeLists {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();

        // Adding employees
        list.add(new Employee(125, "Jai", 30000.00));
        list.add(new Employee(115, "Adi", 25000.00));
        list.add(new Employee(135, "Chai", 40000.00));
        System.out.println(list);
        Stream.of(list);
        Comparator<Employee> compareById = Comparator.comparing(Employee::getSalary);
        Collections.sort(list, (e1, e2) -> {
            if (e1.id == e2.id) return 0;
            else if (e1.id > e2.id) return 1;
            else return -1;
        });
        System.out.println(list);
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();



    }
}
