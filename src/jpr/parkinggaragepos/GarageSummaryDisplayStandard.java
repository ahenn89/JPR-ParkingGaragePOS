

package jpr.parkinggaragepos;

import java.text.NumberFormat;

/**
 *
 * This is a sub class for the way the garage update text displays
 * 
 * @author Jordan Ryder
 */
public class GarageSummaryDisplayStandard implements GarageSummaryDisplay {

    
    /**
     * 
     * This method does the formatting of the text to display
     * 
     * @param transactions
     * @param hours
     * @param fees
     * @return Text that identifies the totals for the garage
     */
    @Override
    public String getGarageSummary(int transactions, double hours, double fees) {
	   
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	return "Totals for Garage: " + transactions + " cars, " + hours + " hours parked, " + fmt.format(fees) + " collected";
    }
    
}
