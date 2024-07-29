import java.util.ArrayList;
import java.util.HashMap;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory_Management_System {
    private HashMap<String, Product> inventory;

    public Inventory_Management_System() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.quantity = quantity;
            product.price = price;
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void printInventory() {
        for (Product product : inventory.values()) {
            System.out.println("ID: " + product.productId + ", Name: " + product.productName + ", Quantity: " + product.quantity + ", Price: " + product.price);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Initialize the inventory management system
        Inventory_Management_System inventorySystem = new Inventory_Management_System();

        // Create some products
        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 20, 599.99);
        Product product3 = new Product("P003", "Tablet", 15, 299.99);

        // Add products to the inventory
        inventorySystem.addProduct(product1);
        inventorySystem.addProduct(product2);
        inventorySystem.addProduct(product3);

        // Print the inventory
        System.out.println("Initial Inventory:");
        inventorySystem.printInventory();

        // Update a product
        inventorySystem.updateProduct("P001", 8, 950.00);
        System.out.println("\nInventory after updating Laptop:");
        inventorySystem.printInventory();

        // Delete a product
        inventorySystem.deleteProduct("P002");
        System.out.println("\nInventory after deleting Smartphone:");
        inventorySystem.printInventory();

        // Retrieve a product
        Product retrievedProduct = inventorySystem.getProduct("P003");
        System.out.println("\nRetrieved Product:");
        if (retrievedProduct != null) {
            System.out.println("ID: " + retrievedProduct.productId + 
                               ", Name: " + retrievedProduct.productName + 
                               ", Quantity: " + retrievedProduct.quantity + 
                               ", Price: " + retrievedProduct.price);
        } else {
            System.out.println("Product not found.");
        }
    }
}