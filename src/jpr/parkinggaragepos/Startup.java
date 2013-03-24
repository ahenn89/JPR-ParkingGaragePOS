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

        Date startDate = new Date();
	Date endDate = new Date();

	
	//set readers, writers, and customer data source
	Reader rd = new GUIReader();
	Writer wr = new GUIWriter();
	CustomerDataSource data = new FakeDatabase();	
	
	
	
	//make up some time ranges where the car was parked
	startDate.setHours(startDate.getHours() - 4); //I realize this is not good practice, however this was my last resort after a lot of frustration trying to get usable code between the Calendar and Date classes.  I even tried to use Joda time, but realized that may not be acceptable given compatibility.
		

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"); 
        String formattedDate = sdf.format(startDate); 
	
        System.out.println("A Formatted Date: " + formattedDate);
	
	formattedDate = sdf.format(endDate); 
	System.out.println("A Formatted Date: " + formattedDate);

	
	
	
	//code for car entering
	Kiosk k = new Kiosk(data, rd, wr);
	k.startNewSale(Date startDate);	 
	
	
	
	//code for car leaving, receipt printed, take money
	
	
	


    }
}
