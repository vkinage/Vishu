import java.sql.*;

public class EmployeeJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String pass = "Swapnil@008";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            // Create Table
            st.executeUpdate("DROP TABLE IF EXISTS Employee");

            st.executeUpdate(
                    "CREATE TABLE Employee(" +
                    "EmpId INT PRIMARY KEY," +
                    "Name VARCHAR(30)," +
                    "Department VARCHAR(20)," +
                    "Salary DOUBLE," +
                    "JoiningDate DATE)"
            );

            // Insert 5 Records
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Employee VALUES(?,?,?,?,?)");

            ps.setInt(1, 101);
            ps.setString(2, "Asha");
            ps.setString(3, "IT");
            ps.setDouble(4, 45000);
            ps.setDate(5, Date.valueOf("2024-01-10"));
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Raj");
            ps.setString(3, "HR");
            ps.setDouble(4, 38000);
            ps.setDate(5, Date.valueOf("2023-05-12"));
            ps.executeUpdate();

            ps.setInt(1, 103);
            ps.setString(2, "Priya");
            ps.setString(3, "IT");
            ps.setDouble(4, 52000);
            ps.setDate(5, Date.valueOf("2022-09-15"));
            ps.executeUpdate();

            ps.setInt(1, 104);
            ps.setString(2, "Dev");
            ps.setString(3, "Finance");
            ps.setDouble(4, 41000);
            ps.setDate(5, Date.valueOf("2021-11-20"));
            ps.executeUpdate();

            ps.setInt(1, 105);
            ps.setString(2, "Neha");
            ps.setString(3, "IT");
            ps.setDouble(4, 47000);
            ps.setDate(5, Date.valueOf("2020-07-01"));
            ps.executeUpdate();

            // Display Records
            ResultSet rs =
                    st.executeQuery("SELECT * FROM Employee");

            System.out.println("Employee Records:\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getDouble(4));
            }

            // Batch Insert
            ps.setInt(1, 106);
            ps.setString(2, "Amit");
            ps.setString(3, "IT");
            ps.setDouble(4, 50000);
            ps.setDate(5, Date.valueOf("2024-03-01"));
            ps.addBatch();

            ps.setInt(1, 107);
            ps.setString(2, "Kiran");
            ps.setString(3, "HR");
            ps.setDouble(4, 42000);
            ps.setDate(5, Date.valueOf("2024-04-01"));
            ps.addBatch();

            ps.executeBatch();

            System.out.println("\nBatch Insert Done");

            // Update Salary
            st.executeUpdate(
                    "UPDATE Employee SET Salary=Salary*1.15 " +
                    "WHERE EmpId=102");

            System.out.println("Salary Updated");

            // Delete Employee
            st.executeUpdate(
                    "DELETE FROM Employee WHERE EmpId=105");

            System.out.println("Employee Deleted");

            // IT Department Employees
            rs = st.executeQuery(
                    "SELECT * FROM Employee WHERE Department='IT'");

            System.out.println("\nIT Department Employees:\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getDouble(4));
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}