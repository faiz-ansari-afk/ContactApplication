package Array;

import java.util.Scanner;

public class ArrayListChallenge {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone("123-456-789-003");
    public static void main(String[] args) {
        mobilePhone.addNewContact(Contact.createContact("Faiz","98778542")); // hard coded contact
        mobilePhone.addNewContact(Contact.createContact("Adnan","45823130"));
        mobilePhone.addNewContact(Contact.createContact("Talha","49521"));
        boolean quit = false;
//        startPhone();
        printActions();
        while(!quit){
            System.out.print("Choose option: (For Options press 6) ");
            int option = scanner.nextInt();
            switch(option){
                case 0:
                    System.out.println("Shutting Down...😊");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNew();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }
    private static void addNew(){
        System.out.print("Contact Name: ");
        String name = scanner.next();
        System.out.println(name);
        scanner.nextLine();
        System.out.print("Contact Number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println(name +" : " + phoneNumber + "   added...");
        }
        else {
            System.out.println("Couldn't add contact... Try again");
            addNew();
        }
    }


    private static  void update(){
        System.out.print("Existing Contact Name: ");
        String oldContactName = scanner.next();
        System.out.println(oldContactName);
        scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(oldContactName);
        if (existingContactRecord == null){
            System.out.println("Contact Doesn't exist");
        }else{
            boolean check =true;
            while(check){
            System.out.print("Enter New Name: ");
            String newContactName = scanner.nextLine();
//            String newContactPhoneNumber = null;


            if (!mobilePhone.checkContactForAvialability(newContactName)){
                check = false;
                System.out.print("Enter the phone number: ");
                String newContactPhoneNumber = scanner.nextLine();
                Contact createNewContact = Contact.createContact(newContactName,newContactPhoneNumber);
                if (mobilePhone.updateContact(existingContactRecord,createNewContact)){
                    System.out.println("successfully updated records");
                }
                else
                    System.out.println("Something went wrong");
            }else{
                System.out.println("Contact with name "+ newContactName + " already exist, choose another name");
             }

            }
        }

    }

    private static void remove(){
        System.out.print("Existing Contact to Remove: ");
        String existingContactName = scanner.next();
        Contact existingContactRecord = mobilePhone.queryContact(existingContactName);
        if (mobilePhone.removeContact(existingContactRecord)){
            System.out.println("successfully removed 😊");
        }
        else
            System.out.println("Cannot find "+ existingContactName +" contact");

    }

    private  static void queryContact(){
        System.out.print("Enter name to query contact: ");
        String contactNameToQuery = scanner.next();
        Contact queryContact = mobilePhone.queryContact(contactNameToQuery);
        if ( queryContact == null){
            System.out.println("Contact not avilable...Try another search..");
            queryContact();
        }
        else
            System.out.println(queryContact.getName() + " --> " + queryContact.getPhoneNumber() + " found in a contact ArrayList😊");
    }
    private static void startPhone(){
        System.out.println("Starting Phone");
    }
    private static void printActions(){
        System.out.println("Avialble Options:\nPress");
        System.out.println("0 - Shutdown\n" +
                "1 - Print Contacts\n" +
                "2 - Add Contact\n" +
                "3 - Update Contact\n" +
                "4 - Remove Contact\n" +
                "5 - Search Contact\n" +
                "6 - Print Options");
    }
}
