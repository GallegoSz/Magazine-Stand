# Magazine Stand Manager 📚🍬🍹

**Magazine Stand Manager** is a Java application that allows you to manage the product inventory of a kiosk. 
With a simple interface based on **JOptionPane**, You can view, add and remove
products such as magazines, sweets and drinks.

---

## 💡 Features
- **View stock:** See all products registered in stock, with details on name, type and price.
- **Add products:** Enter new items into inventory, categorized as:
    - Candy (name, brand and price)
    - Bebidas (name, type and price)
    - Revistas (name, publisher and price)
- **Remove products:** Exclude specific items from inventory based on their position in the list.

---

## 🛠️ Code Structure
O projeto é composto por várias classes para gerenciar diferentes tipos de produtos:

### Main classes
- `MagazineStand`: Contains the main menu and manages user interactions.
- `Products`: Abstract base class for all products. Includes properties like `name` and `price`.
- `Candy`: Represents sweets, with additional properties such as `brand`.
- `Drink`: Represents beverages, with additional properties such as `type`.
- `Magazine`: Represents magazines, with additional properties like `publisher`.

### Main methods
- `showStock`: Displays all products in stock.
- `addProduct`: Allows you to add a new product to the stock.
- `removeProduct`: Removes a product from inventory based on its position.

---

## 🤝 Contributions
Contributions are welcome! Feel free to open issues or submit pull requests for improvements.

---

## 📜 License
This project is licensed under the MIT License.

---

## ✨ Author
Developed with ❤️ by João Pedro Gallego. Get in touch:
- jopedrogallego@hotmail.com
- https://www.linkedin.com/in/joao-pedro-gallego/