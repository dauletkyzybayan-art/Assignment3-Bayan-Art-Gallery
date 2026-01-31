package Model;

import Exceptions.ResourceNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Customers {
    public static void customerInfo () {
        String sql = "SELECT * FROM customers1 WHERE customer_id = ?";
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            while (rs.next()) {
                found = true;
                int customerID = rs.getInt("customer_id");
                String customerName = rs.getString("customer_name");
                int customerBalance = rs.getInt("customer_balance");

                System.out.println("\nName Surname: " + customerName + "\nID: " + customerID + "\nBalance: " + customerBalance);
            }

            if (!found) {
                throw new ResourceNotFoundException("Customer not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void addCustomer() {
        String sql = "INSERT INTO customers1 (customer_id, customer_name) VALUES (?, ?)";

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Enter new Customer ID: ");
            int customerID = sc.nextInt();
            ps.setInt(1, customerID);

            System.out.print("Enter Customer's Name: ");
            String customerName = sc.next();
            ps.setString(2, customerName);

            int rs = ps.executeUpdate();

            System.out.print("Customer added to list successfully.");
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
