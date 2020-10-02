package ContactsListProject;

import java.util.HashMap;
import java.util.Map;

public class Contact {
    private final HashMap<String, Integer> contacts;
    private HashMap<String, Message> messageList;

    public Contact() {
        contacts = new HashMap<>();
        messageList = new HashMap<>();
    }

    public void addContact(String name, int number) {
        contacts.put(name,number);
        messageList.put(name, new Message());
    }
    public void sendMessage(String sender, String recipient, String msg){
        messageList.get(recipient).addMessage("["+sender+"]: " + msg);
    }
    public void readMessages(String name){
        System.out.println(String.format("--- %s's Messages ---",name));
        System.out.println(messageList.get(name).toString());
    }
    public void deleteContact(String name) {
        contacts.remove(name);
        messageList.remove(name);
    }
    public boolean searchContact(String name){
        return contacts.containsKey(name);
    }
    public boolean searchContact(int number){
        return contacts.containsKey(number);
    }

    @Override
    public String toString() {
        String name = "--- Contacts List ---\n";
        for (Map.Entry<String, Integer> entry : contacts.entrySet()){
            name += String.format("%9s %s\n", entry.getKey() + ":", Integer.toString(entry.getValue()));
        }
        return name;
    }
}
