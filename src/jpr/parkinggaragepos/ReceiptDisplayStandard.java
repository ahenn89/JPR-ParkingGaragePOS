



package jpr.parkinggaragepos;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorda_000
 */
public class ReceiptDisplayStandard implements ReceiptDisplay {
     
    
    
    /**
     * This method overrides the toString method and returns a printout of what the
     * receipt will look like when printed from the cash register.  This combines all
     * of the attributes of the transaction
     * 
     * @return Receipt text of the receipt for printing
     */
    @Override
    public String toString() {
	String s = "";

	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	s = addString(s, "\n\n\n*********** Kohls ***********");
	s = addString(s, "******* Proof of Sale *******");

	//add time stamp
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	s = addString(s, dateFormat.format(date)) + "\n";

	s = addString(s, "TESTING!!!!!" + ", Thank You for Shopping at Kohls.\n");
	s = addString(s, "----Item Summary----");


	s += "\n";



	return s;
    }
    
    
    
     /**
     *
     * @return printed receipt
     */
    public String addString(String s1, String s2) {
	return s1 + "\n" + s2;

    }
}
