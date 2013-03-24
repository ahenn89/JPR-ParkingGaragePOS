/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import inputoutput.Reader;
import inputoutput.Writer;
import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class Kiosk {
    
    
    private Receipt receipt;
    private Reader read;
    private CustomerDataSource data;
    private Writer write;
    private Date date ;

    /**
     * @param read reader the determines input methods
     * @param data data connection class to determine what data source to
     * connect to
     */
    public Kiosk(CustomerDataSource data,Reader read, Writer write) {
	this.read = read;
	this.data = data;
	this.write = write;
    }

    /**
     *
     * Nothing much needs to be done here, it just creates a blank receipt that
     * can begin to be populated with items and attributes.
     *
     */
    public void startNewSale(Date startDate) {
	receipt = new Receipt(Date startDate);
    }

    /**
     *
     * Prints receipt by returning a string representing the transaction
     *
     * @return Text of the receipt currently in the cash register
     */
    public String printReceipt() {
	return receipt.toString();
    }
    
       
    
    
     /**
     * Set customer. Does not require any variables to be passed in. The method
     * will read from the user input.
     */
    public void setCustomer() {
	receipt.setCustomer(data.findByCustomerId(read.readAndReturn("Enter Customer Number")));
    }
    
    
    
    
    
}
