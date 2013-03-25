
package jpr.parkinggaragepos;

import java.util.Date;

/**
 *
 * This is the class that determines how much a sales is for a car being parked.
 * The receipt is started when the car arrives, and it is closed after the car leaves
 * and the customer pays.  Only one receipt is created for each car.  Once the 
 * receipt is paid, it will be stored in a list in the garage.  
 * 
 * 
 * @author Jordan Ryder
 */
public class Receipt {
    
    private Customer customer;
    private CustomerDataSource data;
    private Date startDate;
    private Date endDate;
    private double hours;
    private SalesStrategy salesStrategy;

    
    
    
    /**
     * This method uses the passed in ReceiptDisplay to generate the appropriate receipt
     * text to display.  
     * 
     * 
     * @param disp
     * @return Text of receipt
     */
    public String getReceiptText(ReceiptDisplay disp){
	return disp.getReceiptText(customer.getCustomerId(), getHours() , getCharge(), startDate, endDate, customer.getCustomerName());
    }
    
    
    
    /**
     * 
     * This method only calculates the amount of time in hours that have passed while
     * the car has been parked in the garage.  The value is stored internally in the 
     * hours property.
     * 
     */
    public void calculateHours(){
	long secs = (this.endDate.getTime() - this.startDate.getTime()) / 1000;
	this.setHours(secs / 3600);	
    }
    
    
    /**
     * 
     * This calculates the amount due based on the strategy of the specific garage
     * passed in via the SalesStrategy interface
     * 
     * @return Total fee amount due to customer
     */
    public double getCharge(){
	return salesStrategy.getCharge(hours);
    }
    
    /**
     * 
     * This will return the class that is used to retrieve the customer data from 
     * the appropriate data source
     * 
     * @return The data source class
     */
    public CustomerDataSource getData() {
	return data;
    }

    /**
     * 
     * This will set the class that retrieves the customer information
     * 
     * @param data 
     */
    public void setData(CustomerDataSource data) {
	this.data = data;
    }

    
    /**
     * 
     * Gets the date when the car began to park
     * 
     * @return Parking start date
     */
    public Date getStartDate() {
	return startDate;
    }

    
    /**
     * 
     * Sets the date when the car left the parking garage
     * 
     * @param startDate 
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * 
     * Gets the date that the car left the parking garage
     * 
     * @return Parking end date
     */
    public Date getEndDate() {
	return endDate;
    }

    /**
     * 
     * Sets the date that the vehicle leaves the parking garage. Also calculates 
     * the amount of hours the car was parked.  This is done because the hours 
     * can't be calculated until there is a start and end date to the duration the 
     * vehicle was parked.
     * 
     * @param endDate 
     */
    public void setEndDate(Date endDate) {
	this.endDate = endDate;
	calculateHours(); //as soon as there is an end date, generate the hours
    }

    /**
     * 
     * Returns the number of hours the car was parked
     * 
     * @return Hours parked
     */
    public double getHours() {
	return hours;
    }

    /**
     * Sets the hours parked
     * 
     * @param hours 
     */
    public void setHours(double hours) {
	this.hours = hours;
    }

    /**
     * 
     * Returns the SalesStrategy object
     * 
     * @return Sales strategy for vehicle
     */
    public SalesStrategy getSalesStrategy() {
	return salesStrategy;
    }

    
    /**
     * 
     * Sets the Sales Strategy
     * 
     * @param salesStrategy 
     */
    public void setSalesStrategy(SalesStrategy salesStrategy) {
	this.salesStrategy = salesStrategy;
    }
    
    
    /**
     * 
     * Default constructor, requires the start date and the SalesStrategy.  These
     * items are necessary for future calculations.
     * 
     * @param startDate
     * @param ss 
     */
    public Receipt(Date startDate, SalesStrategy ss){
	this.startDate = startDate;    
	this.salesStrategy = ss;
    }

    /**
     * Get the customer object
     * @return Customer
     */
    public Customer getCustomer() {
	return customer;
    }
    
    /**
     * Sets the customer for the receipt.  
     * @param customer 
     */
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
