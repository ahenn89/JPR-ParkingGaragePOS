/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

/**
 *
 * @author jorda_000
 */
public class Customer {
    private String customerId;
    private String customerName;

    
    /**
     * 
     * @return customerName which is the full name of the customer
     */
    public String getCustomerName() {
	return customerName;
    }

    
    /**
     * Setter to set the customer name
     * 
     * @param customerName 
     */
    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }
    
    /**
     * Default construction which does not set any variables
     */
    public Customer(){};
    
    
    /**
     * Constructor that sets both the customerId and the customerName
     * 
     * @param custId
     * @param custName 
     */
    public Customer(String custId, String custName) {
	customerId = custId;
	customerName = custName;
    }

    /**
     * Getter for the customerId property
     * 
     * @return customerId the unique identifier for the customer
     */
    public String getCustomerId(){
	return this.customerId;
    }
}
