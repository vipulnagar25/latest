package problemSolution.stringp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedChars {
  public static void main(String[] args) {

    String str = "vipul kumar is java programmer and he is devloping ecoomrece application";

    Map<Character, Long> freqMap =
        str.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> c != ' ') // ignore spaces
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));

    // Repeated characters
    List<Character> repeated =
        freqMap.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .toList();

    System.out.println("Repeated Characters: " + repeated);
    }
}