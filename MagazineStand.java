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
                    "\n3 - Remove a product from stock");

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
                            .append(candy.getBrand()).append("\nPrice: US$").append(candy.getPrice()).append(" )");
                } else if (product instanceof Drink drink) {
                    productsList.append(" (Drink\n Name: ").append(drink.getName()).append("\nType: ")
                            .append(drink.getName()).append("\nPrice: US$").append(drink.getPrice()).append(" )");
                } else if (product instanceof Magazine magazine) {
                    productsList.append(" (Magazine\n Name: ").append(magazine.getName()).append("\nPublisher: ")
                            .append(magazine.getPublisher()).append("\nPrice: US$").append(magazine.getPrice()).append(" )");
                }
                productsList.append("\n\n");
            }
            JOptionPane.showMessageDialog(null, productsList.toString());
        }
    }

    private static void addProduct(ArrayList<Products> stock) {
        String type = JOptionPane.showInputDialog(null, "Enter the type of product to add (candy, drink, magazine):");
        if (type == null) {
            if (confirmExit()) {
                return;
            }
            return;
        }
        switch (type.toLowerCase()) {
            case "candy":
                String name = JOptionPane.showInputDialog("Enter the candy name:");
                String brand = JOptionPane.showInputDialog("Enter with the brand:");
                double price = getValidPrice(name);
                stock.add(new Candy(name, brand, price));
                break;
            case "drink":
                name = JOptionPane.showInputDialog("Enter the drink name:");
                type = JOptionPane.showInputDialog("enter the type of drink:");
                price = getValidPrice(name);
                stock.add(new Drink(name, type, price));
                break;
            case "magazine":
                name = JOptionPane.showInputDialog("Enter the magazine name:");
                String publisher = JOptionPane.showInputDialog(name + " publisher:");
                price = getValidPrice(name);
                stock.add(new Magazine(name, publisher, price));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid product type!");
        }

    }

    private static void removeProduct(ArrayList<Products> stock) {
        if (stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The stock is currently empty. Nothing to remove.");
        }

        StringBuilder productsList = new StringBuilder("Select a product to remove:\n");
        for (int i = 0; i < stock.size(); i++) {
            Products products = stock.get(i);
            productsList.append(i + 1).append((" - ")).append(products.getName()).append("\n");
        }

        String input = JOptionPane.showInputDialog(productsList.toString());
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Operation canceled by user.");
            return;
        }

        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            return;
        }

        int index = Integer.parseInt(input) - 1;
        if (index < 0 || index >= stock.size()) {
            JOptionPane.showMessageDialog(null, "Invalid product number. Operation canceled.");
            return;
        }

        Products removedProduct = stock.remove(index);
        JOptionPane.showMessageDialog(null, "Product '" + removedProduct.getName() + "' removed successfully!");
    }

    public static boolean confirmExit() {
        int confirmExit = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        return confirmExit == JOptionPane.YES_NO_OPTION;
    }

    private static double getValidPrice(String productName) {
        double price = -1;
        while (price <= 0) {
            try {
                String input = JOptionPane.showInputDialog("Enter the price of " + productName + ":");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    return 0;
                }
                price = Double.parseDouble(input);
                if (price <= 0) {
                    JOptionPane.showMessageDialog(null, "Price must be greater than zero. Try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        return price;
    }
}