



package jpr.parkinggaragepos;

/**
 *
 * @author jorda_000
 */
public class FakeDatabase implements CustomerDataSource {
    
    
        private Customer[] customers = {
        new Customer("100", "Aaron Rodgers"),
        new Customer("200", "Randall Cobb"),
        new Customer("300", "Mason Crosby")
    };
    
    /**
     * 
     * This searches for a customer and returns the customer if a customer ID exists
     * 
     * @param custId
     * @return Customer object of Customer
     */
    
    @Override
    public final Customer findByCustomerId(String custId) {
        // validation is needed
        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
        }
        return customer;
    }


    
    
    
}
