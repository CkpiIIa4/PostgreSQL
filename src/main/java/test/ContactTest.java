package test;

import business.ContactManager;
import entity.Contact;
import exception.ContactBusinessException;

import java.util.List;

public class ContactTest {
    public static void main(String[] args) throws ContactBusinessException {
        ContactManager cm = new ContactManager();

        Contact c1 = new Contact("Mark", "Nukem", "+38-063-111-22-33", "dukenukem@gmail.com");
        Contact c2 = new Contact("Mario", "Super", "+38-067-999-88-77", "supermario@gmail.com");
        Contact c3 = new Contact("Frog", "Crazy", "+38-099-567-89-90", "crazyfrog@gmail.com");

        System.out.println("ADD CONTACT ==========");
        Long cId1 = cm.addContact(c1);
        Long cId2 = cm.addContact(c2);
        Long cId3 = cm.addContact(c3);
        List<Contact> result1 = cm.findContacts();
        for (Contact c : result1) {
            System.out.println(c);
        }

        System.out.println("UPDATE CONTACT ==============");
        Contact change = new Contact(cId1, "Duke", "Nukem", "+38-063-111-22-33", "dukenukem@gmail.com");
        cm.updateContact(change);
        List<Contact> result2 = cm.findContacts();
        for(Contact c : result2) {
            System.out.println(c);
        }

        System.out.println("DELETE CONTACT ==============");
        cm.deleteContact(cId3);
        List<Contact> result3 = cm.findContacts();
        for(Contact c : result3) {
            System.out.println(c);
        }

        System.out.println("GET CONTACT =============");
        Contact contact = cm.getContact(cId2);
        System.out.println(contact);
    }

}
