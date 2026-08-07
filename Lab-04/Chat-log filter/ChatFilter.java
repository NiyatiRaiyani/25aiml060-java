public class ChatFilter {

    public static String filter(String[] logs, String keyword) {

        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (String line : logs) {

            String[] parts = line.split(" ", 3);

            if (parts.length < 3)
                continue;

            String message = parts[2];

            if (message.toLowerCase().contains(keyword.toLowerCase())) {

                count++;

                sb.append(parts[0])
                  .append(" ")
                  .append(parts[1])
                  .append(": ")
                  .append(message)
                  .append("\n");
            }
        }

        return "Matches : " + count + "\n" + sb.toString();
    }

}
