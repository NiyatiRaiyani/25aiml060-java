
import java.util.*;

public class Leaderboard {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Niyati", 95);
        scores.put("Mansi", 88);
        scores.put("Janvi", 95);
        scores.put("Neha", 78);
        scores.put("Aanaya", 88);

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> players =
            new ArrayList<>(scores.entrySet());

        // Sort by score descending, then name ascending
        players.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> p1,
                               Map.Entry<String, Integer> p2) {

                int result =
                    p2.getValue().compareTo(p1.getValue());

                if (result == 0) {
                    return p1.getKey().compareTo(p2.getKey());
                }

                return result;
            }
        });

        // Print top three players
        int topN = 3;

        System.out.println("LEADERBOARD");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println((i + 1) + ". "
                + player.getKey() + " - "
                + player.getValue());
        }
    }
}
