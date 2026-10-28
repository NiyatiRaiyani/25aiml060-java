
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
            "Niyati", "Radha", "Janvi", "Reena", "Niyati", 
            "Radha", "Neha", "Riya", "Karan", "Jay",
            "Neha", "Riya", "Karan", "Mansi", "Jay", "Reena", "Janvi"
        );

        // Count unique users
        Set<String> uniqueUsers = new HashSet<>(logins);

        // Preserve first-seen order
        Set<String> orderedUsers = new LinkedHashSet<>(logins);

        System.out.println("Total login records: " + logins.size());
        System.out.println("Unique visitors: " + uniqueUsers.size());

        System.out.println("First three distinct visitors:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
