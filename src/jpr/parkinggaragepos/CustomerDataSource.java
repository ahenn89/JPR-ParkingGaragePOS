/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpr.parkinggaragepos;

/**
 *
 * @author jorda_000
 */
public interface CustomerDataSource {
    

	public abstract Customer  findByCustomerId(final String custId);
    
}
