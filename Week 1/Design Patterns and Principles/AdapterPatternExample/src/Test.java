public class Test {
    public static void main(String[] args) {

        // Creating gateways
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Creating adapters
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Payment Processing
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(150.0);
    }
}
