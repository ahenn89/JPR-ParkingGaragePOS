/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutput;

import javax.swing.JOptionPane;

/**
 *
 * @author jryder
 */
public class GUIReader implements Reader {

    private String message;
    private String prompt = "Select a value to copy";

    public GUIReader(){}
    
    @Override
    public void setPrompt(String p){
        prompt = p;
    }
    
    @Override
    public void read() {
	this.message = JOptionPane.showInputDialog(null, prompt, prompt, 1);
    }

    @Override
    public String getMessage() {
	return this.message;
    }

    @Override
    public String readAndReturn(String prompt) {
        this.prompt = prompt;
        this.read();
        return this.getMessage();
    }


    
    
    
    
}
