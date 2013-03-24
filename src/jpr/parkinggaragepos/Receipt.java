/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class Receipt {
    
    private Customer customer;
    private CustomerDataSource data;
    private Date startDate;
    private Date endDate;
    
    
    
    public Receipt(Date startDate){
	this.startDate = startDate;    
    }
    
    
    public void setCustomer(Customer customer) {
	this.customer = customer;
    }
    
     /**
     * Return the name of the customer from the customer object
     * @return Customer name
     */
    public String getCustomerName() {
	if (customer == null) {
	    return null;
	}
	return customer.getCustomerName();
    }
    
    
    
}
