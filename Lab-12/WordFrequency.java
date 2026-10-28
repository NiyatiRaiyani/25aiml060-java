
import java.util.*;

public class WordFrequency {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        String paragraph =
            "Java is easy. Java is powerful. Java is popular.";

        Map<String, Integer> frequency = new HashMap<>();

        // Split paragraph into words
        String[] words = paragraph.toLowerCase()
                                   .replaceAll("[^a-z\\s]", "")
                                   .trim()
                                   .split("\\s+");

        // Count word frequency
        for (String word : words) {
            frequency.put(word,
                frequency.getOrDefault(word, 0) + 1);
        }

        // Sort entries by frequency, highest first
        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {
                int result = b.getValue().compareTo(a.getValue());

                if (result == 0) {
                    return a.getKey().compareTo(b.getKey());
                }

                return result;
            }
        });

        // Display sorted frequency
        System.out.println("Word Frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : "
                               + entry.getValue());
        }
    }
}
