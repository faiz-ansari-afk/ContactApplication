package Array;

public class Contact<createContact> {
    private  String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    // main class me directly createContact() call kro isliye static istance method banaye
    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
//    createContact("Faiz","9899977");
}
