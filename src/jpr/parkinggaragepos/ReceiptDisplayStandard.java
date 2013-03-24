package jpr.parkinggaragepos;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class ReceiptDisplayStandard implements ReceiptDisplay {

    /**
     * This method overrides the toString method and returns a printout of what
     * the receipt will look like when printed from the cash register. This
     * combines all of the attributes of the transaction
     *
     * @return Receipt text of the receipt for printing
     */
    @Override
    public String getReceiptText(String carId, double hoursParked, double feeCharged,Date startDate, Date endDate, String customerName) {

	
	//testing
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"); 
        String formattedDate = sdf.format(startDate); 
	
        String prt = ("Parking Start Time: " + formattedDate);
	formattedDate = sdf.format(endDate); 
	prt = prt + "\n"  + "Parking End Time: " + formattedDate;	
	
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	prt = prt + "\n" + String.format("Receipt for car id " + carId + ": " + hoursParked + " hours parked, fee charged: " + fmt.format(feeCharged));
	prt = prt + "\n" + "Thank you " + customerName + "!";
	
	
	return prt;
    }

    public static void main(String[] args) {

	ReceiptDisplayStandard r = new ReceiptDisplayStandard();
	  //  System.out.println(r.getReceiptText("015",5,50));

    }
}
