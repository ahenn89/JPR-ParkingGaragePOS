
package inputoutput;

/**
 *
 * @author jryder
 */
 

public interface Reader {

    public abstract void read();
    public abstract String getMessage();
    public abstract void setPrompt(String s);
    public abstract String readAndReturn(String prompt);
}
