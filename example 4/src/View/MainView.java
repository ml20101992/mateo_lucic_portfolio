package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/24/2018.
 */
public class MainView implements View {

    private JButton add, modify, displayLog, dayInput, addActivity;
    private JPanel view;
    private ArrayList<JButton> buttons = new ArrayList<>();;

    /**
     *
     */
    public MainView() {
        this.view = new JPanel();
        addButtons();
    }

    /**
     *
     */
    private void addButtons() {

        buttons.add(add = new JButton("Add"));
        buttons.add(modify = new JButton("Modify"));
        buttons.add(displayLog = new JButton("View Log"));
        buttons.add(addActivity = new JButton("Add Activity"));

        for(JButton btn: buttons) {
            btn.setPreferredSize(new Dimension(200, 100));
            btn.setBackground(Color.WHITE);
            btn.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
            btn.setBorder(new LineBorder(Color.BLACK));
            view.add(btn);
        }//end of foreach

    }//end of addButtons()

    @Override
    public String getTitle() {
        return "Main Menu";
    }

    @Override
    public JPanel getView() {
        return view;
    }

    @Override
    public void registerListeners(ActionListener listener) {
        for(JButton btn : buttons) {
            btn.addActionListener(listener);
        }
    }

    @Override
    public String[] getData() {

        return new String[0];
    }

    @Override
    public void setData(Object[] model) {

    }
}
