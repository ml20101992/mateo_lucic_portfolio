package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface View {
    String title = "";
    JPanel view = null;
    Font roboto = new Font("Roboto Condensed", Font.PLAIN, 14);

    /**
     * Method used to create a title
     * @return
     */
    public String getTitle();

    /**
     * Method used to get the JPanel for insertion into frame
     * @return
     */
    public JPanel getView();

    /**
     * Method used to register listeners
     * @param listener
     */
    public void registerListeners(ActionListener listener);


    /**
     * Method used to get eventual data
     * @return
     */
    public Object[] getData();

    /**
     * Method used to set the data to model
     * @param model
     */
    public void setData(Object[] model);
}
