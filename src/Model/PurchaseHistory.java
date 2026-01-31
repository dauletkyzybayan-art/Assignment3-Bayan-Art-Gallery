package Model;

import Exceptions.ResourceNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class PurchaseHistory {

    public static void showHistory() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        String sql = """
                SELECT s.sale_id, a.art_name, s.sale_date, s.sale_price
                FROM sales1 s
                JOIN artworks1 a ON s.art_id = a.art_id
                WHERE s.customer_id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            System.out.println("\nPurchase history:");

            while (rs.next()) {
                found = true;
                System.out.println(
                        "\nSale ID: " + rs.getInt("sale_id") +
                                "\nArt: " + rs.getString("art_name") +
                                "\nDate: " + rs.getDate("sale_date") +
                                "\nPrice: " + rs.getDouble("sale_price")
                );
            }

            if (!found) {
                throw new ResourceNotFoundException("No purchases found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
