




package jpr.parkinggaragepos;

import inputoutput.*;
import java.util.Date;

/**
 * 
 * This is the startup/testing method for the Garage Fee application.  
 * Any hard coding is applied in this program, no hard coding of values is needed
 * in the other classes.  
 * 
 * 
 * @author Jordan Ryder
 */
public class Startup {

    
    /**
     * Main method for testing
     * 
     * 
     * @param args 
     */
    public static void main(String[] args) {



	
	//set readers, writers, and customer data source, these can be changed as needed
	Reader rd = new GUIReader();
	Writer wr = new ConsoleWriter();
	CustomerDataSource data = new FakeDatabase();	
	
	
	//pick garage, comment out for testing purposes
	SalesStrategy ss = new BestValue();
	//SalesStrategy ss = new Thrifty();
	
	//choose display types
	ReceiptDisplay disp = new ReceiptDisplayStandard();
	GarageSummaryDisplay gDisp = new GarageSummaryDisplayStandard();


	
	
	//make up some time ranges where the car was parked	
        Date startDate = new Date();
	Date endDate = new Date();	

	startDate.setHours(startDate.getHours() - 4); //I realize this is not good practice, however this was my last resort after a lot of frustration trying to get usable code between the Calendar and Date classes.  I even tried to use Joda time, but realized that may not be acceptable given compatibility.
	
	//end hard coding *******		




	
	//car #1 enters
	Garage k = new Garage(data, rd, wr);
	k.startNewSale(startDate, ss);	 
	k.setCustomer(); //customer will be asked to entere their code in
	
	//car is leaving
	k.setEndDate(endDate);
	
	//customer gets receipt
	String rt = k.printReceipt(disp);
	wr.write(rt);
	
	//close sale and add to daily totals
	k.closeSale();
	
	//display garage totals for testing (does not display to customer)
	wr.write(k.getGarageSummary(gDisp));
	
	
	//change time ranges
	startDate.setHours(startDate.getHours() - 6);
	
	
	
	/*----------------------------------------*/
	
	//car #2 enters
	k.startNewSale(startDate, ss);	 
	k.setCustomer(); //customer will be asked to entere their code in
	
	//car is leaving
	k.setEndDate(endDate);
	
	//customer gets receipt
	rt = k.printReceipt(disp);
	wr.write(rt);
	
	//close sale and add to daily totals
	k.closeSale();
	
	//display garage totals for testing (does not display to customer)
	wr.write(k.getGarageSummary(gDisp));	
	
	System.out.println("");
	
	/*----------------------------------------*/
	
	//car #3 enters
	k.startNewSale(startDate, ss);	 
	k.setCustomer(); //customer will be asked to entere their code in
	
	//car is leaving
	k.setEndDate(endDate);
	
	//customer gets receipt
	rt = k.printReceipt(disp);
	wr.write(rt);
	
	//close sale and add to daily totals
	k.closeSale();
	
	//display garage totals for testing (does not display to customer)
	wr.write(k.getGarageSummary(gDisp));	
	
	
    }
}
