
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {


    public static HashMap<String, String> contactList = new HashMap<>();
    ContactStorage cstorage= new ContactStorage();
    Scanner scanner;


    public PhoneBook() {

    }

    public void addContact(){
        scanner= new Scanner(System.in);
        System.out.println("Enter your contact name:    ");
        String name = scanner.next();
        if (name.equals("0")) {
            return;
        }
        while (contactChecker(name)) {
            System.out.println("Contact with the name \"" + name + "\" already exists.");
            System.out.println("Please choose a different name.");
            name = scanner.next();
        }
        System.out.println("Enter your contacts phone number:   ");
        String phone = scanner.next();
        if (phone.equals("0")) {
            return;
        }
        while (contactChecker(phone)) {
            System.out.println("This phone number already exists.");
            System.out.println("Please enter a different number.");
            phone = scanner.next();
        }
        contactList.put(name, phone);
        cstorage.saveNewContact(name,phone);
        System.out.println("Your contact " + name + " with phoneNumber: " + phone + " has been successfully added!");
        }

    public void showContacts(){
        scanner= new Scanner(System.in);
        System.out.println("name       phone-number");
        for(String key:
                contactList.keySet()){
            System.out.println(key + "       " + contactList.get(key));
        }
        System.out.println(" ");
        System.out.println("Press Enter to return to menu...");
        scanner.nextLine();
        // Wait here until the user presses Enter.

    }

    public void editContact() {
        scanner= new Scanner(System.in);
        String name;
        String number;
        System.out.println("Whats your contacts name you want to edit? ");
        name = scanner.next();
//        First we check contact exits or not
        if (contactChecker(name)) {
            System.out.println("This is your contact now.");
            System.out.println(name + " : ");
            System.out.println(contactList.get(name));
            System.out.println(" Enter new number to replace:");
            number = scanner.next();
            contactList.put(name, number);
            System.out.println("Contact updated successfully!  " + name + " :  " + number);
            ContactStorage.upload();
        } else if (name.equals("0")) {
            return;
        } else {
            System.out.println("Contact with this name not found!");
        }
    }

    public void deleteContact(){
        scanner= new Scanner(System.in);
        System.out.println("1-  Delete a contact");
        System.out.println("2- Delete all contacts");
        System.out.println("0- Back to main menu");

        String delMenu= scanner.nextLine();
        switch (delMenu){
            case "1":
                System.out.println("Enter contact name you want to delete:  ");
                String name= scanner.nextLine();
                if(contactChecker(name)){
                    contactList.remove(name);
                    ContactStorage.upload();
                    System.out.println("Your contact " + name + " deleted successfully!");
                }else {
                    System.out.println("Contact not found");
                }
                break;
            case "2":
                contactList.clear();
                ContactStorage.upload();
                System.out.println("All contacts deleted successfully!  ");
                System.out.println("Press Enter to return to menu...");
                scanner.nextLine();
                break;
            case "0":
                return;

        }

    }

    public boolean contactChecker(String contact) {
        boolean num = contactList.containsKey(contact);
        boolean name = contactList.containsValue(contact);
        return num || name;
    }
}