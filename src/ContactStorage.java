import java.io.*;
import java.util.Scanner;

public class ContactStorage {
        // For Save method
        BufferedWriter writer;

        //For load method
        Scanner scanner;

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
            initstorage();
//            throw new RuntimeException(e);
        }

    }
}










