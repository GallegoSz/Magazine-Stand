import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MagazineStand {
    public static void main(String[] args) {
        ArrayList<Products> stock = new ArrayList<>();
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

    private static void showStock(ArrayList<Products> stock) {
        if (stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The stock is currently empty!");
        } else {
            StringBuilder productsList = new StringBuilder("Stock products:\n");
            for (int i = 0; i < stock.size(); i++) {
                Products product = stock.get(i);
                productsList.append(i + 1).append(" - ").append(product.getName()).append("\n");

                if (product instanceof Candy candy) {
                    productsList.append(" (Candy\n Name: ").append(candy.getName()).append("\nBrand: ")
                            .append(candy.getBrand()).append("\nPrice: ").append(candy.getPrice()).append(" )");
                } else if (product instanceof Drink drink) {
                    productsList.append(" Drink\n Name: ").append(drink.getName()).append("\nType: ")
                            .append(drink.getName()).append("\nPrice: ").append(drink.getPrice()).append(" )");
                } else if (product instanceof Magazine magazine) {
                    productsList.append(" Magazine\n Name: ").append(magazine.getName()).append("\nPublisher: ")
                            .append(magazine.getPublisher()).append("\nPrice: ").append(magazine.getPrice()).append(" )");
                }
                productsList.append("\n");
            }
            JOptionPane.showMessageDialog(null, productsList.toString());
        }
    }

    private static void addProduct(ArrayList<Products> stock) {
        String productInserted = options();
        StringBuilder product = new StringBuilder("Add products:\n");

    }

    private static void removeProduct(ArrayList<Products> stock) {
        System.out.println("remove");
    }

    public static boolean confirmExit() {
        int confirmExit = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        return confirmExit == JOptionPane.YES_NO_OPTION;
    }

    public static String options() {
        String[] validWords = {"candy", "drink", "magazine"};
        boolean isValid = false;
        String input = null;

        while (!isValid) {
            input = JOptionPane.showInputDialog(null, "Enter one of the accepted words" +
                    "\ncandy, drink or magazine");

            if (input != null) {
                for (String word : validWords) {
                    if (input.equalsIgnoreCase(word)) {
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) {
                    JOptionPane.showMessageDialog(null, "Invalid word. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Entry cancelled. Leaving the program.");
                System.exit(0);
            }
        }
        JOptionPane.showMessageDialog(null, "Word accepted! Continuing...");
        return input;
    }
}