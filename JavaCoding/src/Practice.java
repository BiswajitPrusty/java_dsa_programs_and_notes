import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice {
    public static List<Integer> chooseFleets(List<Integer> wheels) {
        List<Integer> result = new ArrayList<>();

        for (int wheel : wheels) {
            if (wheel % 2 != 0) {
                result.add(0);
            } else {
                result.add((wheel / 4) + 1);
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> wheels = Arrays.asList(2, 5, 6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> chooseFleets(wheels));
//        System.out.println(chooseFleets(wheels));
        executorService.shutdown();
    }
}