package dao;

public class CustomersMySqlDAOFactory {
    public static CustomersMySqlDAO getContactMySqlDAO() {
        return new CustomersDbMySqlDAO();
    }
}
