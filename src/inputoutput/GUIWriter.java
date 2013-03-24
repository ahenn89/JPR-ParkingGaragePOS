
package inputoutput;

import javax.swing.JOptionPane;

/**
 *
 * @author jryder
 */
public class GUIWriter implements Writer {

    @Override
    public void write(String message) {
	JOptionPane.showMessageDialog(null,message);
    }
    
}
