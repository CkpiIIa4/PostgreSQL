package dao;

import entity.Customers;
import exception.ContactDAOException;
import java.util.List;

public interface CustomersMySqlDAO
{
    Long addCustomers(Customers customers) throws ContactDAOException;
    void updateCustomers(Customers customers) throws ContactDAOException;
    void deleteCustomers(Long idCustomers) throws ContactDAOException;
    Customers getCustomers(Long idCustomers) throws ContactDAOException;

    List<Customers> findCustomers() throws ContactDAOException;
}