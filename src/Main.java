import Model.Arts;
import Model.Balance;
import Model.Customers;
import Model.Sales;
import Model.PurchaseHistory;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Art Gallery Management System" +
                    "\n\n1. List of Arts \n2. Add a new Art \n3. Remove the Art" +
                    "\n\n4. Sell art \n5. Customer's purchase history \n6. Art information" + "\n7. Customer information" +
                    "\n\n8. Add customer \n9. Add balance \n0. Remove balance" +
                    "\n\nSelect: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Arts.artLists();
                    System.out.print("\nEnter anything to exit: ");
                    String leave1 = scanner.next();
                    break;
                case 2:
                    Arts.addArt();
                    System.out.print("\nEnter anything to exit: ");
                    String leave2 = scanner.next();
                    break;
                case 3:
                    Arts.removeArt();
                    System.out.print("\nEnter anything to exit: ");
                    String leave3 = scanner.next();
                    break;
                case 4:
                    Sales.sellArt();
                    System.out.print("\nEnter anything to exit: ");
                    scanner.next();
                    break;
                case 5:
                    PurchaseHistory.showHistory();
                    System.out.print("\nEnter anything to exit: ");
                    scanner.next();
                    break;
                case 6:
                    Arts.artInfo();
                    System.out.print("\nEnter anything to exit: ");
                    String leave6 = scanner.next();
                    break;
                case 7:
                    Customers.customerInfo();
                    System.out.print("\nEnter anything to exit: ");
                    String leave7 = scanner.next();
                    break;
                case 8:
                    Customers.addCustomer();
                    System.out.print("\nEnter anything to exit: ");
                    String leave8 = scanner.next();
                    break;
                case 9:
                    Balance.addBalance();
                    System.out.print("\nEnter anything to exit: ");
                    String leave9 = scanner.next();
                    break;
                case 0:
                    Balance.removeBalance();
                    System.out.print("\nEnter anything to exit: ");
                    String leave0 = scanner.next();
                    break;
            }
        } while (true);
    }
}