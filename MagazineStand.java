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
                            .append(candy.getBrand()).append("\nPrice: ").append(candy.getPrice()).append(" )");
                } else if (product instanceof Drink drink) {
                    productsList.append(" (Drink\n Name: ").append(drink.getName()).append("\nType: ")
                            .append(drink.getName()).append("\nPrice: ").append(drink.getPrice()).append(" )");
                } else if (product instanceof Magazine magazine) {
                    productsList.append(" (Magazine\n Name: ").append(magazine.getName()).append("\nPublisher: ")
                            .append(magazine.getPublisher()).append("\nPrice: R$").append(magazine.getPrice()).append(" )");
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
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of " + name + ":"));
                stock.add(new Candy(name, brand, price));
                break;
            case "drink":
                name = JOptionPane.showInputDialog("Enter the drink name:");
                type = JOptionPane.showInputDialog("enter the type of drink:");
                price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of " + name + ":"));
                stock.add(new Drink(name, type, price));
                break;
            case "magazine":
                name = JOptionPane.showInputDialog("Enter the magazine name:");
                String publisher = JOptionPane.showInputDialog(name + " publisher:");
                price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of " + name + ":"));
                stock.add(new Magazine(name, publisher, price));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid product type!");
        }

    }

    private static void removeProduct(ArrayList<Products> stock) {
        System.out.println("remove");
    }

    public static boolean confirmExit() {
        int confirmExit = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        return confirmExit == JOptionPane.YES_NO_OPTION;
    }
}