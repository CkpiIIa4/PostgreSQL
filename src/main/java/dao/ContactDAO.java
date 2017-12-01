package dao;

import entity.Contact;
import exception.ContactDAOException;
import java.util.List;

public interface ContactDAO
{
    Long addContact(Contact contact) throws ContactDAOException;
    void updateContact(Contact contact) throws ContactDAOException;
    void deleteContact(Long contactId) throws ContactDAOException;
    Contact getContact(Long contactId) throws ContactDAOException;

    List<Contact> findContacts() throws ContactDAOException;
}
