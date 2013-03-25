

package jpr.parkinggaragepos;

/**
 *
 * This interface dictates what methods a data source needs to have
 * 
 * @author Jordan Ryder
 */
public interface CustomerDataSource {
    

	public abstract Customer  findByCustomerId(final String custId);
    
}
