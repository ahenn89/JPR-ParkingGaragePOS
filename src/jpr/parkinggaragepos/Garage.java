
package jpr.parkinggaragepos;

import inputoutput.Reader;
import inputoutput.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 
 * This class represents the garage that will be charging vehicles to park.
 * This class has information about the vehicles being stored, and the overall 
 * numbers for the garage as far as sales and numbers go.
 * 
 * 
 * @author Jordan Ryder
 */
public class Garage {

    //configuration and I/O variables
    private Reader read;
    private Writer write;   
    private CustomerDataSource data;
    private GarageSummaryDisplay gsd;
    
    //other
    private Receipt receipt;
    private List<Receipt> receiptList = new <Receipt>ArrayList();

    /**
     * 
     * Default construction, requires data source and I/O strategies
     * 
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
     * 
     * Gives the text for the garage summary, including transactions, hours parked,
     * and total fees
     * 
     * @param gsd
     * @return Summary text for garage totals
     */
    public String getGarageSummary(GarageSummaryDisplay gsd) {
	return gsd.getGarageSummary(this.getTotalGarageTransactions(), this.getTotalGarageHours(), this.getTotalGarageFees());

    }

    /**
     * Nothing much needs to be done here, it just creates a blank receipt that
     * can begin to be populated with items and attributes.
     */
    public void startNewSale(Date startDate, SalesStrategy ss) {
	receipt = new Receipt(startDate, ss);
    }

    
    /**
     * 
     * Closes the sale after the customer has paid.  The receipt object is added
     * to the list of receipts for the day in the garage, then the receipt is cleared
     * for the next transaction
     * 
     */
    public void closeSale() {
	receiptList.add(receipt);
	receipt = null;
    }

    
    /**
     * 
     * Gives the sum of all hours for vehicles parking in the garage
     * 
     * @return total hours for the Garage
     */
    public double getTotalGarageHours() {

	double hours = 0;

	//loop through all receipts and add the hours
	for (Receipt r : receiptList) {
	    hours += r.getHours();
	}

	return hours;


    };
    
    
    /**
     * 
     * Gets the total fees for the Garage
     * 
     * @return total fees for the garage
     */
    public double getTotalGarageFees() {
	double fees = 0;

	//loop through receipts and add fees
	for (Receipt r : receiptList) {
	    fees += r.getCharge();
	}

	return fees;
    }

    /**
     * 
     * Counts the number of cars that have parked and paid for the garage
     * 
     * @return total transactions
     */
    public int getTotalGarageTransactions() {
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

    
    /**
     * 
     * Sets the end date for the receipt, not the garage.  Only a pass through method
     * 
     * @param endDate 
     */
    public void setEndDate(Date endDate) {

	receipt.setEndDate(endDate);
    }

    
    /**
     * Get the read class
     * 
     * @return reader class
     */
    public Reader getRead() {
	return read;
    }

    /**
     * Set the reader class
     * 
     * @param read 
     */
    public void setRead(Reader read) {
	this.read = read;
    }

    
    /**
     * Get the writer class
     * 
     * @return writer class
     */
    
    public Writer getWrite() {
	return write;
    }

    /**
     * Set the writer class
     * 
     * @param write
     */
    
    public void setWrite(Writer write) {
	this.write = write;
    }

    
    /**
     * Get the data object
     * @return Data strategy object
     */
    public CustomerDataSource getData() {
	return data;
    }

    
    /**
     * Set the data source object
     * @param data 
     */
    public void setData(CustomerDataSource data) {
	this.data = data;
    }

    /**
     * Get the garage summary strategy object
     * @return 
     */
    public GarageSummaryDisplay getGsd() {
	return gsd;
    }

    
    /**
     * Set the garage strategy object
     * @param gsd 
     */
    public void setGsd(GarageSummaryDisplay gsd) {
	this.gsd = gsd;
    }

    /**
     * Get the receipt object
     * @return receipt
     */
    public Receipt getReceipt() {
	return receipt;
    }

    
    /**
     * set the receipt object
     * @param receipt 
     */
    public void setReceipt(Receipt receipt) {
	this.receipt = receipt;
    }

    
    /**
     * Return the list of receipts
     * @return Receipt list
     */
    public List<Receipt> getReceiptList() {
	return receiptList;
    }

    /**
     * Set the receipt list
     * 
     * @param receiptList 
     */
    public void setReceiptList(List<Receipt> receiptList) {
	this.receiptList = receiptList;
    }

    /**
     * Set customer. Does not require any variables to be passed in. The method
     * will read from the user input.
     */
    public void setCustomer() {
	receipt.setCustomer(data.findByCustomerId(read.readAndReturn("Please Enter Your Customer Number")));
    }
}
