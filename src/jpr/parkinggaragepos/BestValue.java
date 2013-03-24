/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

/**
 *
 * @author jorda_000
 */
public class BestValue implements SalesStrategy {
    
    public static final double minCharge = 2;
    public static final double minThreshold = 3;
    public static final double hourlyRate = 0.50;
    public static final double maxCharge = 10;
    
    
    @Override
    public double getCharge(double hoursParked) {
	
	double extraHours;
	double extraCharge;
	double totalCharge;
	
	//check if hours are over the minumum
	if(hoursParked < minThreshold){
	    extraHours = 0;
	}
	else{
	    extraHours = Math.ceil(hoursParked - minThreshold);
	}
	
	//bill customer at hourly rate after minimum exceeded
	extraCharge = extraHours * hourlyRate;
	
	//make sure the customer is not billed over the maximum charge
	if(extraCharge + minCharge > maxCharge){
	    totalCharge = maxCharge;
	}
	else{
	    totalCharge = extraCharge + minCharge;
	}
	
	return totalCharge;
	
    }
    
    
    public static void main(String[] args) {
	
	BestValue v = new BestValue();
	    
	double x =v.getCharge(40);
	
	System.out.println(x);
	
    }
    
    
    
    
    
}
