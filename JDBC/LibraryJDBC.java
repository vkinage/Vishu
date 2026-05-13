import java.sql.*;

public class LibraryJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String pass = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            // Drop Tables
            st.executeUpdate("DROP TABLE IF EXISTS IssuedBooks");
            st.executeUpdate("DROP TABLE IF EXISTS Books");

            // Create Books Table
            st.executeUpdate(
                    "CREATE TABLE Books(" +
                    "BookId INT PRIMARY KEY," +
                    "Title VARCHAR(30)," +
                    "Author VARCHAR(30)," +
                    "Category VARCHAR(20)," +
                    "Available INT)"
            );

            // Create IssuedBooks Table
            st.executeUpdate(
                    "CREATE TABLE IssuedBooks(" +
                    "IssueId INT PRIMARY KEY," +
                    "BookId INT," +
                    "StudentName VARCHAR(30)," +
                    "IssueDate DATE," +
                    "ReturnDate DATE)"
            );

            // Insert Books
            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO Books VALUES(?,?,?,?,?)");

            ps.setInt(1, 1);
            ps.setString(2, "Core Java");
            ps.setString(3, "Schildt");
            ps.setString(4, "Tech");
            ps.setInt(5, 1);
            ps.executeUpdate();

            ps.setInt(1, 2);
            ps.setString(2, "DBMS");
            ps.setString(3, "Korth");
            ps.setString(4, "Tech");
            ps.setInt(5, 1);
            ps.executeUpdate();

            ps.setInt(1, 3);
            ps.setString(2, "Fiction");
            ps.setString(3, "Chetan");
            ps.setString(4, "Fiction");
            ps.setInt(5, 1);
            ps.executeUpdate();

            // Display Books
            ResultSet rs =
                    st.executeQuery("SELECT * FROM Books");

            System.out.println("Books List:\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3));
            }

            // Issue Book Transaction
            con.setAutoCommit(false);

            try {

                PreparedStatement issue =
                        con.prepareStatement(
                                "INSERT INTO IssuedBooks VALUES(?,?,?,?,?)");

                issue.setInt(1, 1);
                issue.setInt(2, 1);
                issue.setString(3, "Asha");
                issue.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                issue.setDate(5, null);

                issue.executeUpdate();

                PreparedStatement update =
                        con.prepareStatement(
                                "UPDATE Books SET Available=0 WHERE BookId=1");

                update.executeUpdate();

                con.commit();

                System.out.println("\nBook Issued");

            } catch (Exception e) {

                con.rollback();

                System.out.println("Issue Failed");
            }

            // Return Book
            try {

                PreparedStatement ret =
                        con.prepareStatement(
                                "UPDATE IssuedBooks SET ReturnDate=? WHERE IssueId=1");

                ret.setDate(1,
                        new java.sql.Date(System.currentTimeMillis()));

                ret.executeUpdate();

                PreparedStatement update2 =
                        con.prepareStatement(
                                "UPDATE Books SET Available=1 WHERE BookId=1");

                update2.executeUpdate();

                con.commit();

                System.out.println("Book Returned");

            } catch (Exception e) {

                con.rollback();
            }

            // Delete Book
            st.executeUpdate(
                    "DELETE FROM Books WHERE BookId=3");

            System.out.println("Book Deleted");

            // Display Tech Books
            PreparedStatement tech =
                    con.prepareStatement(
                            "SELECT * FROM Books WHERE Category=?");

            tech.setString(1, "Tech");

            rs = tech.executeQuery();

            System.out.println("\nTech Books:\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2));
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}