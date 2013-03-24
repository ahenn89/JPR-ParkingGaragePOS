package jpr.parkinggaragepos;

import java.text.NumberFormat;

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
    public String getReceiptText(String carId, double hoursParked, double feeCharged) {

	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	String prt = String.format("Receipt for car id " + carId + ": " + hoursParked + " hours parked, fee charged: " + fmt.format(feeCharged));

	return prt;
    }

    public static void main(String[] args) {

	ReceiptDisplayStandard r = new ReceiptDisplayStandard();
	    System.out.println(r.getReceiptText("015",5,50));

    }
}
