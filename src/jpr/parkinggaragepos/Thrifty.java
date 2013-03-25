
package jpr.parkinggaragepos;

/**
 *
 * This class represents the sales strategy for Thrifty Garage
 * Thrifty does not have a maximum charge, but cars are not expected to 
 * park longer than 24 hours straight.  If they do, they will be towed.
 * The towing charge is not not included in this program.
 * 
 * 
 * 
 * @author Jordan Ryder
 */
public class Thrifty implements SalesStrategy {

    //these variables should not change, as they are the standard rules for Thrifty
    public static final double minCharge = 1.5;
    public static final double minThreshold = 2;
    public static final double hourlyRate = 0.75;

    
    /**
     * 
     * This method calculates the total charges for a car based on the number of 
     * hours the car was parked for.  
     * 
     * @param hoursParked
     * @return totalCharge - amount the vehicle is charged for parking
     */
    @Override
    public double getCharge(double hoursParked) {

	double extraHours;
	double extraCharge;
	double totalCharge;

	//check if hours are over the minumum
	if (hoursParked < minThreshold) {
	    extraHours = 0;
	} else {
	    extraHours = Math.ceil(hoursParked - minThreshold);
	}

	//bill customer at hourly rate after minimum exceeded
	extraCharge = extraHours * hourlyRate;


	totalCharge = extraCharge + minCharge;


	return totalCharge;

    }

    
    /**
     * Returns the min charge for parking
     * 
     * 
     * @return minCharge
     */
    public static double getMinCharge() {
	return minCharge;
    }

    
    /**
     * 
     * Returns the amount of time before the hourly rate charges begin
     * 
     * @return minThreshold
     */
    public static double getMinThreshold() {
	return minThreshold;
    }

    
    /**
     * 
     * Returns the hourly rate applied after the minimum hours end
     * 
     * @return hourlyRate
     */
    public static double getHourlyRate() {
	return hourlyRate;
    }

    
    /**
     * Testing method only
     * 
     * 
     * @param args 
     */
    public static void main(String[] args) {

	Thrifty v = new Thrifty();

	double x = v.getCharge(40);

	System.out.println(x);

    }
}
