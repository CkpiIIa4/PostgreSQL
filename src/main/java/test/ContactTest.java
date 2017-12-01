package test;

import business.CustomersManger;
import entity.Customers;
import exception.ContactBusinessException;

public class ContactTest {
    public static void main(String[] args) throws ContactBusinessException {

    /*    ContactTest ct = new ContactTest();
        ct.testDatabase();
    }

    private void testDatabase() {

        System.out.println("------- Проверка подключения к MySQL -------");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Customers",
                    "root", "mySQL");
        } catch (SQLException ex) {
            Logger.getLogger(ContactTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        if(null != connection) {
            System.out.println("------- Подключение установлено -------");
        } else {
            System.out.println("------- Подключение НЕ установлено -------");
            }
        }
    }*/


        /*try {
            GlobalConfig.initGlobalConfig();
            GuiResources.initComponentResources();
        } catch (Exception ex)
        {
            ex.printStackTrace(System.out);
            return;
        }

        ContactFrame cf = new ContactFrame();
        cf.setVisible(true);*/
        
        CustomersManger cm = new CustomersManger();
        cm.findCustomers();
        System.out.println( cm.findCustomers());
    }
}

