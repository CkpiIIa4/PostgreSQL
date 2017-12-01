package dao;

import entity.Customers;
import exception.ContactDAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomersDbMySqlDAO implements CustomersMySqlDAO {
    private static final String SELECT
            = "SELECT * FROM Customers";
    private static final String SELECT_ONE
            = "SELECT * FROM Customers WHERE idCustomers = ?";
    private static final String INSERT
            = "INSERT INTO Customers (idCustomers, Name, Company) \n" +
            " VALUES (4, 'John', 'Robotics');";
    private static final String UPDATE
            = "UPDATE Customers SET Name = ?, Company = ?, WHERE idCustomers = ?";
    private static final String DELETE
            = "DELETE FROM Customers WHERE idCustomers = ?";

    private ConnectionBuilder builder = new MySqlConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long addCustomers(Customers customers) throws ContactDAOException {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT, new String[]{"idCustomers"})) {
            Long idCustomers = -1L;
            pst.setInt(1, customers.getIdCustomers());
            pst.setString(2, customers.getName());
            pst.setString(3, customers.getCompany());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                idCustomers = gk.getLong("idCustomers");
            }
            gk.close();
            return idCustomers;
        } catch (Exception e) {
            throw new ContactDAOException(e);
        }
    }

    @Override
    public void updateCustomers(Customers customers) throws ContactDAOException {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(UPDATE)) {
            pst.setString(2, customers.getName());
            pst.setString(3, customers.getCompany());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new ContactDAOException(e);
        }
    }

    @Override
    public Customers getCustomers(Long idCustomers) throws ContactDAOException {
        Customers customers = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(SELECT_ONE);
            pst.setLong(1, idCustomers);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                customers = fillCustomers(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new ContactDAOException(e);
        }
        return customers;
    }


    @Override
    public void deleteCustomers(Long idCustomers) throws ContactDAOException {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE)) {
            pst.setLong(1, idCustomers);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new ContactDAOException(e);
        }
    }


    @Override
    public List<Customers> findCustomers() throws ContactDAOException {
        List<Customers> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillCustomers(rs));
            }
            rs.close();
        } catch (Exception e) {
            throw new ContactDAOException(e);
        }
        return list;
    }

    private Customers fillCustomers(ResultSet rs) throws SQLException {
        Customers customers = new Customers();
        customers.setIdCustomers(rs.getInt("idCustomers"));
        customers.setName(rs.getString("Name"));
        customers.setCompany(rs.getString("Company"));
        return customers;
    }
}