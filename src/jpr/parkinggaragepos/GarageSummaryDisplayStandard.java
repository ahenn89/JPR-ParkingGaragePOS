/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

import java.text.NumberFormat;

/**
 *
 * @author jorda_000
 */
public class GarageSummaryDisplayStandard implements GarageSummaryDisplay {

    @Override
    public String getGarageSummary(int transactions, double hours, double fees) {
	   
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	return "Totals for Garage: " + transactions + " cars, " + hours + " hours parked, " + fmt.format(fees) + " collected";
    }
    
}
