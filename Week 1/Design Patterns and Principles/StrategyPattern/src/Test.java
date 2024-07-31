public class Test {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        //Credit Card Payment
        PaymentStrategy creditCard= new CreditCardPayment("1234-5678-9012-3456", "Rushda Aliya");
        paymentContext.setPaymentStrategy(creditCard);
        paymentContext.executePayment(250.75);

        //PayPal Payment
        PaymentStrategy payPal = new PayPalPayment("rushdaaliyae@egamil.com");
        paymentContext.setPaymentStrategy(payPal);
        paymentContext.executePayment(120.50);
    }
}
