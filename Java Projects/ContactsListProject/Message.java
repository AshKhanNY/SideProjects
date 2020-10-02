package ContactsListProject;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Message {
    private final ArrayList<String> messages;

    public Message() {
        messages = new ArrayList<>();
    }
    public void addMessage(String message){
        messages.add(message);
    }
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String name = String.format("(Accessed on %s...)\n",dtf.format(now));
        for (String temp : messages){
            name += temp + "\n";
        }
        return name;
    }
}
