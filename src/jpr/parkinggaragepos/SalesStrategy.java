


package jpr.parkinggaragepos;

/**
 *
 * This interface dictates the requirements for the different types of charges that
 * a garage could have
 * 
 * @author Jordan Ryder
 */


public interface SalesStrategy {
    /**
     * 
     * This method will 
     * 
     * @param hoursParked
     * @return 
     */
    public abstract double getCharge(double hoursParked);    
    
}
