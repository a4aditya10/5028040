public class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp received stock price update: $" + stockPrice);
    }
}
