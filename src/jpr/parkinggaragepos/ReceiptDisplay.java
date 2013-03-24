/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import java.util.Date;

/**
 *
 * @author jorda_000
 */
public interface ReceiptDisplay {
    
    public abstract String getReceiptText(String carId, double hoursParked, double feeCharged, Date startDate, Date endDate, String customerName);
    
}
