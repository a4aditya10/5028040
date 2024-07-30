class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

class OrderSorter {
    public void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
public class Main {
    public static void main(String[] args) {
        // Create an array of Order objects
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.00),
            new Order("O004", "David", 100.20),
            new Order("O005", "Eve", 200.00)
        };

        // Instantiate the OrderSorter class
        OrderSorter sorter = new OrderSorter();

        // Display the original order list
        System.out.println("Original Order List:");
        printOrders(orders);

        // Sort the orders using bubble sort
        sorter.bubbleSort(orders);
        System.out.println("\nOrder List after Bubble Sort:");
        printOrders(orders);

        // Shuffle the orders to demonstrate quick sort
        Order[] shuffledOrders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.00),
            new Order("O004", "David", 100.20),
            new Order("O005", "Eve", 200.00)
        };

        // Sort the orders using quick sort
        sorter.quickSort(shuffledOrders, 0, shuffledOrders.length - 1);
        System.out.println("\nOrder List after Quick Sort:");
        printOrders(shuffledOrders);
    }

    // Helper method to print the list of orders
    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer: " + order.customerName +", Total Price: $" + order.totalPrice);
        }
    }
}
