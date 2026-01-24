package Model;
import java.sql.*;
import java.util.Scanner;

public class Arts {
    public static void artLists() {
        String sql = "SELECT * FROM artworks1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("Arts in aviabile:");
            boolean found = false;
            int number = 0;

            while (rs.next()) {
                found = true;
                number++;
                int artID = rs.getInt("art_id");
                String artName = rs.getString("art_name");
                String artAuthor = rs.getString("art_author");
                int artPrice = rs.getInt("art_price");
                System.out.println("\n\n" + number + ". " + artName + "\nArt ID: " + artID + "\nPrice: " + artPrice);
            }

            if (!found) {
                System.out.println("Arts not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void artInfo() {
        String sql = "SELECT * FROM artworks1 WHERE art_id = ?";
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            System.out.print("Enter art ID: ");
            int id =  scanner.nextInt();

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            while (rs.next()) {
                found = true;
                int artID = rs.getInt("art_id");
                String artName = rs.getString("art_name");
                String artAuthor = rs.getString("art_author");
                int artPrice = rs.getInt("art_price");
                String artDate = rs.getString("art_date");
                System.out.println("\n\n" +  "Art Name: " + artName + "\nArt ID: " + artID + "\nPrice: " + artPrice +
                        "\nCreated in: " + artDate + "\nAuthor: "  + artAuthor);
            }
            if (!found) {
                System.out.println("Art not found");
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addArt() {
        String sql = "INSERT INTO artworks1 (art_id, art_name, art_date, art_author, art_price) VALUES (?, ?, ?, ?, ?)";

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter new Art ID: ");
            int artID = sc.nextInt();
            ps.setInt(1, artID);

            System.out.print("Enter Art Name: ");
            String artName = sc.next();
            ps.setString(2, artName);

            System.out.print("When was it created (Example 2024-01-01): ");
            String artDate = sc.next();
            ps.setString(3, artDate);

            System.out.print("Enter Art Author: ");
            String artAuthor = sc.next();
            ps.setString(4, artAuthor);

            System.out.print("Enter Art Price: ");
            int artPrice = sc.nextInt();
            ps.setInt(5, artPrice);

            int rs = ps.executeUpdate();

            System.out.print("Art added successfully in aviabile");
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeArt() {
        String sql = "DELETE FROM artworks1 WHERE art_id = ?";

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter new Art ID: ");
            int artID = sc.nextInt();
            ps.setInt(1, artID);

            int rs = ps.executeUpdate();

            System.out.print("Art deleted successfully");
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
