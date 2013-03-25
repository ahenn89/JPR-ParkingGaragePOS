
package jpr.parkinggaragepos;

/**
 *
 * This class represents the sales strategy for BestValue Garage
 * BestValue has a maximum charge, so if the amount exceeds that, it will be capped
 * at the maxCharge amount.
 * 
 * 
 * @author Jordan Ryder
 */
public class BestValue implements SalesStrategy {
    
    //variables will not need to be changed.  If there are additional strategies, they will be handled in new SalesStrategy classes
    public static final double minCharge = 2;
    public static final double minThreshold = 3;
    public static final double hourlyRate = 0.50;
    public static final double maxCharge = 10;

    /**
     * 
     * Minimum charge amount
     * 
     * @return Minimum amount a vehicle will be charged
     */
    public static double getMinCharge() {
	return minCharge;
    }

    
    /**
     * 
     * Gets the hours before the hourly rate starts to be applied
     * 
     * @return Hours before hourly rates start to occur.   
     */
    public static double getMinThreshold() {
	return minThreshold;
    }

    
    /**
     * 
     * Hourly rate charged
     * 
     * @return Hourly rate charged
     */
    public static double getHourlyRate() {
	return hourlyRate;
    }

    /**
     * 
     * Maximum possible charge for a vehicle
     * 
     * @return Maximum charge for a vehicle
     */
    public static double getMaxCharge() {
	return maxCharge;
    }
    
    /**
     * 
     * This calculates the amount to charge the vehicle based on the rules of the garage / strategy
     * 
     * @param hoursParked
     * @return Amount vehicle will be charged
     */
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
    
    /**
     * 
     * Testing method only
     * 
     * @param args 
     */
    public static void main(String[] args) {
	
	BestValue v = new BestValue();
	    
	double x =v.getCharge(40);
	
	System.out.println(x);
	
    }
    
    
    
    
    
}
