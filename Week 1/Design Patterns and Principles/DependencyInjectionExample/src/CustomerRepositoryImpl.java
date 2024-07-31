public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would query the database.
        return new Customer(id, "Rushda Aliya");
    }
}
