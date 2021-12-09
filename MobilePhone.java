package Array;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
//        System.out.println("Enter ");
        if (findContact(contact.getName()) >=0){
            System.out.println("Contact already exists...");
            return false;
        }
        myContact.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int findPosition = findContact(oldContact);
        if (findPosition <0 ){
            System.out.println(oldContact + " doesn't exist to update.");
            return false;
        }
        else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact with "+ newContact.getName() +" already exist");
        }
        this.myContact.set(findPosition,newContact);
        System.out.println(oldContact.getName() + " is updated to " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int findPosition  = myContact.indexOf(contact);
        if (findPosition < 0 ){
            return false;
        }
        this.myContact.remove(findPosition);
        System.out.println(contact.getName() + " is removed");
        return true;
    }


    public void printContact(){
        System.out.println("====================== Contact List =====================");
        for (int i =0; i<this.myContact.size(); i++){
            System.out.println(
                    (i+1) + ") " + this.myContact.get(i).getName() + " --> " + this.myContact.get(i).getPhoneNumber()
            );
        }
        System.out.println("==========================================================");
    }





// this method is publicly available for all class to access becaz we only return String name if availble (on Query)
    public String queryContact(Contact contact){
        if (findContact(contact) >=0){
            return contact.getName();
        }
        return null;
    }
    //this method will take string and return contact data type
    public Contact queryContact(String name){
        int position =findContact(name);
        if (position >=0){
            return this.myContact.get(position);
        }
        return null;
    }
    public boolean checkContactForAvialability(String name){
        int position = findContact(name);
        if (position >= 0){
            return true;
        }
        return false;
    }
    //below methods are private bcz we dont want access other class our array detail(index no)
    private int findContact(Contact contact){
        //myContact is ArrayList of {name and PhoneNumber} so we can get
        return  this.myContact.indexOf(contact);
    }
    //oVer riding above method to return index of contact so that we can update it
    private int findContact(String contactName){
        for (int i=0; i<this.myContact.size(); i++){
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
}
