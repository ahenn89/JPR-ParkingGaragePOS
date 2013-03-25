
package jpr.parkinggaragepos;


/**
 *
 * This interface dictates what methods are required for the displaying of receipt
 * information
 * 
 * @author Jordan Ryder
 */
public interface GarageSummaryDisplay {
    
    
    /**
     * 
     * This method will actually do the formatting of the text to display
     * 
     * @param transactions
     * @param hours
     * @param fees
     * @return Text for garage summary
     */
    public abstract String getGarageSummary(int transactions, double hours, double fees);
    
    
    
}
