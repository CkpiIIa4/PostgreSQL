package test;

import config.GlobalConfig;
import gui.ContactFrame;
import gui.GuiResources;

public class ContactTest {
    public static void main(String[] args) {

    /*    ContactTest ct = new ContactTest();
        ct.testDatabase();
    }

        private void testDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM JC_CONTACT");
                while (rs.next()) {
                    String str = rs.getString("contact_id") + ":" + rs.getString(2);
                    System.out.println("Contact:" + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    }
}
