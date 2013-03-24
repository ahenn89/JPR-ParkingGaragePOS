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
    private double hours;
    private SalesStrategy salesStrategy;

    
    
    
    
    public String getReceiptText(ReceiptDisplay disp){
	return disp.getReceiptText(customer.getCustomerId(), getHours() , getCharge());
    }
    
    
    public void calculateHours(){
	long secs = (this.endDate.getTime() - this.startDate.getTime()) / 1000;
	this.hours = secs / 3600;	
    }
    
    
    
    public double getCharge(){
	return salesStrategy.getCharge(hours);
    }
    
    
    public CustomerDataSource getData() {
	return data;
    }

    public void setData(CustomerDataSource data) {
	this.data = data;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
	calculateHours(); //as soon as there is an end date, generate the hours
    }

    public double getHours() {
	return hours;
    }

    public void setHours(double hours) {
	this.hours = hours;
    }

    public SalesStrategy getSalesStrategy() {
	return salesStrategy;
    }

    public void setSalesStrategy(SalesStrategy salesStrategy) {
	this.salesStrategy = salesStrategy;
    }
    
    
    public Receipt(Date startDate, SalesStrategy ss){
	this.startDate = startDate;    
	this.salesStrategy = ss;
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
