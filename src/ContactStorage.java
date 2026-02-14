import java.io.*;
import java.util.Scanner;

public class ContactStorage {
        // For Save method
        BufferedWriter writer;

        //For load method
        Scanner scanner;

// it makes a phonebook.txt, we use it when phonebook.txt is not there. Like using app for the first time ...
    public void initstorage(){
            try {
                writer = new BufferedWriter(new FileWriter("PhoneBook.txt", true));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public void saveNewContact(String name, String phone){
            try {
                writer = new BufferedWriter(new FileWriter("PhoneBook.txt", true));
                writer.write(name + " " + phone + "\n");
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//        it overwrites an empty phonebook.txt, then writes data from hash-map to the file again
//          because it is a txt file and doesnt have delete-row and update options like a database.
    public static void upload(){
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("PhoneBook.txt"));
            for (String contact:
                    PhoneBook.contactList.keySet()) {
                    writer.write(contact + " " + PhoneBook.contactList.get(contact) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//   Reads  from PhoneBook.txt and puts into contact list hashmap
    public void load(){
        try {
            scanner = new Scanner(new File("PhoneBook.txt"));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts= line.split(" ");
                String name= parts[0];
                String phone= parts[1];
                PhoneBook.contactList.put(name, phone);

            }
        } catch (FileNotFoundException e) {
//            if file not found, creates a phonebook.txt file
            initstorage();
//            throw new RuntimeException(e);
        }

    }
}










