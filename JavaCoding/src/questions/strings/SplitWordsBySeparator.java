package questions.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitWordsBySeparator {

    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        return words.stream()
                .map(word -> word.split("\\" + separator)) // Split each word by the separator
                .flatMap(Arrays::stream) // Flatten the arrays
                .filter(s -> !s.isEmpty()) // Exclude empty strings
                .collect(Collectors.toList());
    }
}
