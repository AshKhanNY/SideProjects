package ContactsListProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contact myContacts = new Contact();
        Scanner scan = new Scanner(System.in);
        String name;
        int number;
        System.out.println("Welcome to your phone! You have 3 options.\n");
        int mainMenu, contactMenu, msgMenu;
        mainMenu = contactMenu = msgMenu = 0;
        do {
            System.out.println("MAIN MENU\n\t1. Manage Contacts\n\t2. Messages\n\t3. Quit\n");
            mainMenu = scan.nextInt();
            if (mainMenu == 1){
                do {
                    System.out.println("CONTACTS MENU\n\t\t1. Show All Contacts\n\t\t2. Add New Contact\n\t\t" +
                            "3. Search For A Contact\n\t\t4. Delete A Contact\n\t\t5. Back To Prev Menu\t");
                    contactMenu = scan.nextInt();
                    switch(contactMenu){
                        case 1:
                            System.out.println(myContacts);
                            break;
                        case 2:
                            System.out.println("Please enter the name of contact.");
                            name = scan.next();
                            System.out.println("Please enter contact number.");
                            number = scan.nextInt();
                            myContacts.addContact(name,number);
                            System.out.println("Contact added.\n");
                            break;
                        case 3:
                            System.out.println("Who are you trying to find? Please enter a " +
                                    "name or a number.");
                            boolean exists = false;
                            if (scan.hasNextInt()){
                                number = scan.nextInt();
                                exists = myContacts.searchContact(number);
                            } else if (scan.hasNext()){
                                name = scan.next();
                                exists = myContacts.searchContact(name);
                            }
                            if (exists) System.out.println("Contact exists!");
                            else System.out.println("Contact does not exist.");
                            break;
                        case 4:
                            System.out.println("Which contact would you like to delete? Please " +
                                    "enter a name.");
                            name = scan.next();
                            if (myContacts.searchContact(name)){
                                myContacts.deleteContact(name);
                                System.out.println("Contact deleted successfully.");
                            } else System.out.println("Unable to delete, contact not found.");
                            break;
                        default:
                            break;
                    }
                } while (contactMenu != 5);
            } else if (mainMenu == 2){
                do {
                    System.out.println("MESSAGE MENU\n\t\t1. See List of All Messages\n\t\t" +
                            "2. Send New Message\n\t\t3. Back To Prev Menu\t");
                    msgMenu = scan.nextInt();
                    switch (msgMenu){
                        case 1:
                            System.out.println("Who's messages would you like to view?");
                            name = scan.next();
                            if (myContacts.searchContact(name)){
                                myContacts.readMessages(name);
                            } else System.out.println("Contact not found.");
                            break;
                        case 2:
                            System.out.println("Please state your name, who you are sending to, " +
                                    "and the message itself.");
                            name = scan.next();
                            if (!myContacts.searchContact(name)){
                                System.out.println("Invalid name, contact not found.");
                                break;
                            }
                            String recipient = scan.next();
                            if (!myContacts.searchContact(recipient)){
                                System.out.println("Invalid name, contact not found.");
                                break;
                            }
                            String msg = scan.nextLine();
                            msg = scan.nextLine();
                            myContacts.sendMessage(name, recipient, msg);
                            break;
                        default:
                            break;
                    }
                } while (msgMenu != 3);
            }
        } while (mainMenu != 3);
    }
}
