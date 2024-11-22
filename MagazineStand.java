import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MagazineStand {
    public static void main(String[] args) {
        ArrayList<String> stock = new ArrayList<>();
        String response;

        JOptionPane.showMessageDialog(null, "Welcome to your magazine stand manager!");

        while (true) {
            response = JOptionPane.showInputDialog("\nWhat would you like to do? (Enter only numbers)" +
                    "\n1 - Show stock products" +
                    "\n2 - Add product to stock" +
                    "\n3 - Remove a product from stock" +
                    "\n0 - Exit");

            if (response == null) {
                if (confirmExit()) {
                    return;
                } else {
                    continue;
                }
            }

            if (!response.matches("[1-3]")) {
                JOptionPane.showMessageDialog(null, "Invalid option! Please enter a valid number.");
                continue;
            }

            switch (response) {
                case "1":
                    showStock(stock);
                    break;
                case "2":
                    addProduct(stock);
                    break;
                case "3":
                    removeProduct(stock);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please enter a valid number.");
            }
        }
    }

    private static void showStock(ArrayList<String> stock) {
        if (stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "\nThe stock is currently empty!");
        } else {
            JOptionPane.showMessageDialog(null, "Stock prducts: ");
            for (int i = 0; i < stock.size(); i++) {
                System.out.println((i + 1) + " - " + stock.get(i));
            }
        }
    }

    private static void addProduct(ArrayList<String> stock) {
        System.out.println("add");
    }

    private static void removeProduct(ArrayList<String> stock) {
        System.out.println("remove");
    }

    public static boolean confirmExit() {
        int confirmExit = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        return confirmExit == JOptionPane.YES_NO_OPTION;
    }
}