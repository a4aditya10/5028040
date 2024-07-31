public class Test {
    public static void main(String[] args) {
        // StockMarket instance
        StockMarket stockMarket = new StockMarket();

        // observer instances
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers with the StockMarket
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        // Changing stock prices and notifying observers
        System.out.println("Setting stock price to $120.50");
        stockMarket.setStockPrice(120.50);

        System.out.println("\nSetting stock price to $125.75");
        stockMarket.setStockPrice(125.75);

        // Deregister an observer
        System.out.println("\nDeregistering MobileApp Observer");
        stockMarket.deregister(mobileApp);

        // Change stock price and notify remaining observers
        System.out.println("\nSetting stock price to $130.00");
        stockMarket.setStockPrice(130.00);
    }
}
