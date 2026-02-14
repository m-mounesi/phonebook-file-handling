import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        ContactStorage cstorage= new ContactStorage();
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String menu;
        while (running) {

    // At application startup, load data from 'phonebook.txt' if it exists.
        cstorage.load();

            System.out.println("Hi, choose the option you want to do: ");
            System.out.println("1- Add new contact");
            System.out.println("2- Show contacts");
            System.out.println("3- Edit contact");
            System.out.println("4- Delete contact");
            System.out.println("0- Close App");

            menu = scanner.next();

            switch (menu) {
                case "1":
                    phoneBook.addContact();
                    break;

                case "2":
                    System.out.println("These are your saved contacts!");
                    phoneBook.showContacts();
                    break;
                case "3":
                    phoneBook.editContact();
                    break;
                case "4":
                    System.out.println("Enter contact name you want to delete:   ");
                    phoneBook.deleteContact();
                    break;
                case "0":
                    System.out.println("Good Bye !");
                    running = false;
                    break;
            }
        }

    }
}