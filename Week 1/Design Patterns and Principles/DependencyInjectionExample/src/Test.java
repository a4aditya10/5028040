public class Test {
    public static void main(String[] args) {

        // Creating repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Injecting repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Using the service to find a customer
        Customer customer = customerService.getCustomerById("1");

        // Displaying customer details
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}
