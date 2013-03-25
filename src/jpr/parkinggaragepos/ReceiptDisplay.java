


package jpr.parkinggaragepos;

import java.util.Date;

/**
 *
 * This interface dictates what is required for the receipt to display.  This interface
 * is used by the Receipt.  Different receipt displays may be used.  
 * 
 * 
 * @author Jordan Ryder
 */
public interface ReceiptDisplay {
    
    /**
     * 
     * This method returns the text of the receipt.
     * 
     * @param carId
     * @param hoursParked
     * @param feeCharged
     * @param startDate
     * @param endDate
     * @param customerName
     * @return Receipt Text - the way the text will display when printed out to the receipt
     */
    public abstract String getReceiptText(String carId, double hoursParked, double feeCharged, Date startDate, Date endDate, String customerName);
    
}
