
package inputoutput;

/**
 *
 * @author jryder
 */
public class ConsoleWriter implements Writer{

    @Override
    public void write(String message) {
	System.out.println("The console copied " + message);
    }
    
}
