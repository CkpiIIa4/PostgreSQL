package dao;

import entity.Contact;
import exception.ContactDAOException;
import java.util.List;

public interface ContactDAO
{
    public Long addContact(Contact contact) throws ContactDAOException;
    public void updateContact(Contact contact) throws ContactDAOException;
    public void deleteContact(Long contactId) throws ContactDAOException;
    public Contact getContact(Long contactId) throws ContactDAOException;

    public List<Contact> findContacts() throws ContactDAOException;
}
