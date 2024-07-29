class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class ECommercePlatform {
    private Product[] products;

    public ECommercePlatform(Product[] products) {
        this.products = products;
    }

    public Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = productName.compareTo(products[mid].productName);

            if (result == 0) {
                return products[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Smartwatch", "Wearables")
        };

        // Instantiate the ECommercePlatform with the products
        ECommercePlatform platform = new ECommercePlatform(products);

        // Perform linear search
        Product foundProduct = platform.linearSearch("Tablet");
        if (foundProduct != null) {
            System.out.println("Linear Search - Product found: " + foundProduct.productName);
        } else {
            System.out.println("Linear Search - Product not found.");
        }

        // Perform binary search (assuming the array is sorted)
        Product foundProductBinary = platform.binarySearch("Smartwatch");
        if (foundProductBinary != null) {
            System.out.println("Binary Search - Product found: " + foundProductBinary.productName);
        } else {
            System.out.println("Binary Search - Product not found.");
        }
    }
}