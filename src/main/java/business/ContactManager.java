package business;

import dao.ContactDAO;
import dao.ContactDAOFactory;
import entity.Contact;
import exception.ContactBusinessException;
import exception.ContactDAOException;
import java.util.List;

public class ContactManager {
    private final ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }

    public Long addContact(Contact contact) throws ContactBusinessException {
        try {
            return dao.addContact(contact);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public Long addContactByContract(Contact contact) throws ContactBusinessException {
        try {
            contact.setEmail("");
            return dao.addContact(contact);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public void updateContact(Contact contact) throws ContactBusinessException {
        try {
            dao.updateContact(contact);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public void deleteContact(Long contactId) throws ContactBusinessException {
        try {
            dao.deleteContact(contactId);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public Contact getContact(Long contactId) throws ContactBusinessException {
        try {
            return dao.getContact(contactId);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public List<Contact> findContacts() throws ContactBusinessException {
        try {
            return dao.findContacts();
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }
}
