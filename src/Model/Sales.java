package Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Sales {

    public static void sellArt() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Art ID: ");
        int artId = sc.nextInt();

        String checkArt = "SELECT art_price, art_status FROM artworks1 WHERE art_id = ?";
        String checkCustomer = "SELECT customer_balance FROM customers1 WHERE customer_id = ?";
        String updateArt = "UPDATE artworks1 SET art_status = 'T' WHERE art_id = ?";
        String updateCustomer = "UPDATE customers1 SET customer_balance = customer_balance - ? WHERE customer_id = ?";
        String insertSale = """
                INSERT INTO sales1 (sale_id, art_id, customer_id, sale_date, sale_price)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            // Проверка artwork
            PreparedStatement psArt = conn.prepareStatement(checkArt);
            psArt.setInt(1, artId);
            ResultSet artRs = psArt.executeQuery();

            if (!artRs.next()) {
                System.out.println("Art not found");
                return;
            }

            if (!"F".equals(artRs.getString("art_status"))) {
                System.out.println("Art already sold");
                return;
            }

            double price = artRs.getDouble("art_price");

            // Проверка клиента
            PreparedStatement psCust = conn.prepareStatement(checkCustomer);
            psCust.setInt(1, customerId);
            ResultSet custRs = psCust.executeQuery();

            if (!custRs.next()) {
                System.out.println("Customer not found");
                return;
            }

            double balance = custRs.getDouble("customer_balance");

            if (balance < price) {
                System.out.println("Not enough balance");
                return;
            }

            // Обновляем статус арта
            PreparedStatement psUpdateArt = conn.prepareStatement(updateArt);
            psUpdateArt.setInt(1, artId);
            psUpdateArt.executeUpdate();

            // Списываем баланс
            PreparedStatement psUpdateCust = conn.prepareStatement(updateCustomer);
            psUpdateCust.setDouble(1, price);
            psUpdateCust.setInt(2, customerId);
            psUpdateCust.executeUpdate();

            // Добавляем продажу
            PreparedStatement psSale = conn.prepareStatement(insertSale);
            psSale.setInt(1, (int) (Math.random() * 100000));
            psSale.setInt(2, artId);
            psSale.setInt(3, customerId);
            psSale.setDate(4, Date.valueOf(LocalDate.now()));
            psSale.setDouble(5, price);
            psSale.executeUpdate();

            conn.commit();
            System.out.println("Art sold successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
