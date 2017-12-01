package business;

import dao.CustomersMySqlDAO;
import dao.CustomersMySqlDAOFactory;
import entity.Customers;
import exception.ContactBusinessException;
import exception.ContactDAOException;

import java.util.List;

public class CustomersManger {
    private final CustomersMySqlDAO daoMySql;

    public CustomersManger() {
        daoMySql = CustomersMySqlDAOFactory.getContactMySqlDAO();
    }

    public Long addCustomers(Customers customers) throws ContactBusinessException {
        try {
            return daoMySql.addCustomers(customers);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public void updateCustomers(Customers customers) throws ContactBusinessException {
        try {
            daoMySql.updateCustomers(customers);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public void deleteCustomers(Long idCustomers) throws ContactBusinessException {
        try {
            daoMySql.deleteCustomers(idCustomers);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public Customers getCustomers(Long idCustomers) throws ContactBusinessException {
        try {
            return daoMySql.getCustomers(idCustomers);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public List<Customers> findCustomers() throws ContactBusinessException {
        try {
            return daoMySql.findCustomers();
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
    }
}
