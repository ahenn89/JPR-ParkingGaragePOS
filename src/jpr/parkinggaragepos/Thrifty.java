/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

/**
 *
 * @author jorda_000
 */
public class Thrifty implements SalesStrategy {

    public static final double minCharge = 1.5;
    public static final double minThreshold = 2;
    public static final double hourlyRate = 0.75;

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

    public static double getMinCharge() {
	return minCharge;
    }

    public static double getMinThreshold() {
	return minThreshold;
    }

    public static double getHourlyRate() {
	return hourlyRate;
    }

    public static void main(String[] args) {

	Thrifty v = new Thrifty();

	double x = v.getCharge(40);

	System.out.println(x);

    }
}
