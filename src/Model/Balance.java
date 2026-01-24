package Model;

import java.sql.*;
import java.util.Scanner;

public class Balance {
    public static void addBalance() {
        String sql = "UPDATE customers1 SET customer_balance = customer_balance + ? WHERE customer_id = ?";
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter customer ID: ");
            int id = sc.nextInt();
            ps.setInt(2, id);
            System.out.print("Enter balance: ");
            int balance = sc.nextInt();
            ps.setInt(1, balance);

            int rs = ps.executeUpdate();

            System.out.print("Balance updated successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeBalance() {
        String sql = "UPDATE customers1 SET customer_balance = customer_balance + ? WHERE customer_id = ?";
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter customer ID: ");
            int id = sc.nextInt();
            ps.setInt(2, id);
            System.out.print("Enter balance: ");
            int balance = sc.nextInt();
            ps.setInt(1, balance);

            int rs = ps.executeUpdate();

            System.out.print("Balance updated successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
