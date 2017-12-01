package test;

import business.CustomersManger;
import config.GlobalConfig;
import exception.ContactBusinessException;
import gui.ContactFrame;
import gui.GuiResources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactTest {
    public static void main(String[] args) throws ClassNotFoundException, ContactBusinessException {

        ContactTest ct = new ContactTest();
        ct.testDatabase();
    }

    private void testDatabase() throws ClassNotFoundException, ContactBusinessException {

    /*    System.out.println("------- Проверка подключения к MySQL -------");

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customers",
                    "root", "mySQL");
        } catch (SQLException ex) {
            Logger.getLogger(ContactTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        String selectAll = "SELECT * FROM customers";

        try {
            List<String> list = new ArrayList<>();
            Statement stmt = connection.createStatement();
            ResultSet rs =  stmt.executeQuery(selectAll);
            while (rs.next()) {
                list.add(rs.getString("Company"));
                System.out.println(list);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (null != connection) {
            System.out.println("------- Подключение установлено -------");
        } else {
            System.out.println("------- Подключение НЕ установлено -------");
        }
    }
}*/

        try {
            GlobalConfig.initGlobalConfig();
            GuiResources.initComponentResources();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }

        ContactFrame cf = new ContactFrame();
        cf.setVisible(true);

        CustomersManger cm = new CustomersManger();
        cm.findCustomers();
        System.out.println(cm.findCustomers());
    }
}

