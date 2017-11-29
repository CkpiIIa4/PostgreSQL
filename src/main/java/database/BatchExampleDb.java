package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExampleDb {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            try (Connection con = DriverManager.getConnection(url, "postgres", "postgres")) {
                addBatch(con);
                select(con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addBatch(Connection con) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO JC_CONTACT (first_name, last_name, phone, email)"
                        + "VALUES (?, ?, ? ,?)", new String[]{"contact_id"})) {
            for (int i = 0; i < 10; i++) {
                pstmt.setString(1, "FirstName_" + i);
                pstmt.setString(2, "LastName_" + i);
                pstmt.setString(3, "phone_" + i);
                pstmt.setString(4, "email_" + i);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            ResultSet gk = pstmt.getGeneratedKeys();
            while (gk.next()) {
                System.out.println("Inserted:" + gk.getString(1));
            }

        }
    }

    private static void select(Connection con) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM jc_contact; DELETE FROM jc_contact")) {
            boolean test = stmt.execute();
            while (test || stmt.getUpdateCount() > -1) {
                if (test) {
                    try (ResultSet rs = stmt.getResultSet()) {
                        while (rs.next()) {
                            String str = rs.getString("contact_id:" + rs.getString(1));
                            System.out.println("Contact:" + str);
                        }
                    }
                } else {
                    System.out.println("Update SQL is executed:" + stmt.getUpdateCount());
                }
                System.out.println("========================================");
                test = stmt.getMoreResults();
            }
        }
    }
}
