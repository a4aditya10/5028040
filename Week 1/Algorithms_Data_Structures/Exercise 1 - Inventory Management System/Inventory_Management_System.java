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
