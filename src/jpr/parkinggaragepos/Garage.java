/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import inputoutput.Reader;
import inputoutput.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorda_000
 */
public class Garage {

    //configuration and I/O variables
    private Reader read;
    private CustomerDataSource data;
    private Writer write;
    //other
    private Receipt receipt;
    private List<Receipt> receiptList = new <Receipt>ArrayList();

    /**
     * @param read reader the determines input methods
     * @param data data connection class to determine what data source to
     * connect to
     */
    public Garage(CustomerDataSource data, Reader read, Writer write) {
	this.read = read;
	this.data = data;
	this.write = write;
    }

    
    
    /**
     * Nothing much needs to be done here, it just creates a blank receipt that
     * can begin to be populated with items and attributes.
     */
    public void startNewSale(Date startDate, SalesStrategy ss) {
	receipt = new Receipt(startDate, ss);
    }

    public void closeSale() {
	receiptList.add(receipt);
	receipt = null;

    }

    public double getTotalGarageHours() {

	double hours = 0;

	for (Receipt r : receiptList) {
	    hours += r.getHours();
	}

	return hours;


    }

    ;
    
    public double getTotalGarageFees() {
	double fees = 0;

	for (Receipt r : receiptList) {
	    fees += r.getHours();
	}

	return fees;
    }

    public double getTotalGarageTransactions() {
	int tran = 0;

	for (Receipt r : receiptList) {
	    tran += 1;
	}
	return tran;
    }

    /**
     *
     * Prints receipt by returning a string representing the transaction
     *
     * @return Text of the receipt currently in the cash register
     */
    public String printReceipt(ReceiptDisplay r) {


	return receipt.getReceiptText(r);


    }

    public void setEndDate(Date endDate) {

	receipt.setEndDate(endDate);
    }

    /**
     * Set customer. Does not require any variables to be passed in. The method
     * will read from the user input.
     */
    public void setCustomer() {
	receipt.setCustomer(data.findByCustomerId(read.readAndReturn("Enter Customer Number")));
    }
}
