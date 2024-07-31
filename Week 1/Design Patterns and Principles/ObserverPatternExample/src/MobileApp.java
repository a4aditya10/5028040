public class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp received stock price update: $" + stockPrice);
    }
}
