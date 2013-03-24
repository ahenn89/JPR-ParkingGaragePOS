/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import inputoutput.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class Startup {

    public static void main(String[] args) {



	
	//set readers, writers, and customer data source
	Reader rd = new GUIReader();
	Writer wr = new GUIWriter();
	CustomerDataSource data = new FakeDatabase();	
	
	
	//pick garage, comment out for testing purposes
	SalesStrategy ss = new BestValue();
	//SalesStrategy ss = new Thrifty();
	
	
	ReceiptDisplay disp = new ReceiptDisplayStandard();
	

	//end hard coding *******
	
	
	//make up some time ranges where the car was parked	
        Date startDate = new Date();
	Date endDate = new Date();	

	startDate.setHours(startDate.getHours() - 4); //I realize this is not good practice, however this was my last resort after a lot of frustration trying to get usable code between the Calendar and Date classes.  I even tried to use Joda time, but realized that may not be acceptable given compatibility.
		

	//testing
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"); 
        String formattedDate = sdf.format(startDate); 
	
        System.out.println("Parking Start Time: " + formattedDate);
	formattedDate = sdf.format(endDate); 
	System.out.println("Parking End Time: " + formattedDate);


	
	//code for car entering
	Garage k = new Garage(data, rd, wr);
	k.startNewSale(startDate, ss);	 
	k.setCustomer(); //customer will be asked to entere their code in
	
	
	
	k.setEndDate(endDate);
	
	
	
	String rt = k.printReceipt(disp);
	
	System.out.println(rt);
	
	//close sale and add to daily totals
	k.closeSale();
	
	//code for car leaving, receipt printed, take money
	
	
	


    }
}
