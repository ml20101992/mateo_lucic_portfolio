package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 4/24/2018.
 */
public class FirstView implements View {

    private String title;
    private JPanel view, datePanel;
    private JButton continueBtn, defaultBtn;
    private JTextField limit, weight;
    private JComboBox<String> year, month, day;
    Font roboto = new Font("Roboto Condensed", Font.PLAIN, 14);


    /**
     * FirstView Constructor
     * Initiates the JPanel with the required objects
     */
    public FirstView() {

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        title = "Main";
        view = new JPanel();
        view.setLayout(new BorderLayout());

        JPanel instructionsPanel = new JPanel();
        JLabel welcome = new JLabel("Welcome to Diet Manager");

        welcome.setHorizontalTextPosition(JLabel.CENTER);
        welcome.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
        instructionsPanel.add(welcome);

        view.add(instructionsPanel, BorderLayout.NORTH);

        datePanel = new JPanel();
        datePanel.setFont(roboto);
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setFont(roboto);
        year = new JComboBox<>();
        year.setPreferredSize(new Dimension(100,25));
        year.setFont(roboto);
        for(int i = 2018; i < 2028; i++) {
            year.addItem(Integer.toString(i));
        }
        datePanel.add(yearLabel);
        datePanel.add(year);

        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setFont(roboto);
        month = new JComboBox<>();
        month.setPreferredSize(new Dimension(50,25));
        month.setFont(roboto);
        for(int i = 1; i <= 12; i++) {
            month.addItem(Integer.toString(i));
        }

        datePanel.add(monthLabel);
        datePanel.add(month);

        JLabel dayLabel = new JLabel("Day:");
        dayLabel.setFont(roboto);
        day = new JComboBox<>();
        day.setPreferredSize(new Dimension(50,25));
        day.setFont(roboto);
        for(int i = 1; i <= days[month.getSelectedIndex()]; i++) {
            day.addItem(Integer.toString(i));
        }

        datePanel.add(dayLabel);
        datePanel.add(day);

        month.addActionListener(new ActionListener() {
            @Override //onchange event for the month combobox
            public void actionPerformed(ActionEvent e) {
                day.removeAllItems();                                               //remove all items
                boolean isLeap = false;;                                            //is it a leap year
                int leap = Integer.parseInt(year.getSelectedItem().toString());     //currently selected year
                //check if divisible by 4
                if( (leap % 4) == 0) {
                    //check if divisible by 100
                    if( (leap % 100) == 0 ) {
                        //if not divisible by 100 check if divisible by 400
                        if( (leap % 400) == 0) {
                            isLeap = true;
                        }
                        else {
                            isLeap = false;
                        }
                    }
                    else {
                        isLeap = true;
                    }
                }//end of if
                if(isLeap) {
                    days[1] = 29;
                }
                else {
                    days[1] = 28;
                }
                //populate day ComboBox
                for(int i = 1; i <= days[month.getSelectedIndex()]; i++) {
                    day.addItem(Integer.toString(i));
                }
            }
        });//end of anonymous ActionListener()

        JPanel south = new JPanel(new GridLayout(2,1));
        JPanel limitWeightPanel = new JPanel();

        JLabel limitLabel = new JLabel("Calorie Limit:");
        limitLabel.setFont(roboto);
        limit = new JTextField(6);
        limit.setFont(roboto);
        limit.setMargin(new Insets(3,3,3,3));
        limitWeightPanel.add(limitLabel);
        limitWeightPanel.add(limit);

        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(roboto);
        weight = new JTextField(6);
        weight.setFont(roboto);
        weight.setMargin(new Insets(3,3,3,3));
        limitWeightPanel.add(weightLabel);
        limitWeightPanel.add(weight);
        south.add(limitWeightPanel);

        view.add(datePanel, BorderLayout.CENTER);

        addButtons(south);
        view.add(south, BorderLayout.SOUTH);

    }//end of FirstView()

    /**
     *
     */
    private void addButtons(JPanel panel) {

        JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(continueBtn = createButton("Continue", "continue"));
            buttonPanel.add(defaultBtn = createButton("Default", "default"));
        panel.add(buttonPanel);

    }//end of addButtons()

    /**
     * Creates a custom JButton object
     * Helps avoid DRY principle
     * @param title JButton title
     * @param command JButton action command
     * @return Custom JButton object
     */
    private JButton createButton(String title, String command) {
        JButton btn = new JButton(title);
        btn.setActionCommand(command);
        btn.setBackground(Color.WHITE);
        btn.setBorder(new LineBorder(Color.BLACK));
        btn.setPreferredSize(new Dimension(100, 40));
        btn.setFont(roboto);
        return btn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public JPanel getView() {
        return view;
    }

    @Override
    public void registerListeners(ActionListener listener) {
        continueBtn.addActionListener(listener);
        defaultBtn.addActionListener(listener);
    }

    @Override
    public String[] getData() {
        String date = String.format("%s-%s-%s", year.getSelectedItem().toString(), month.getSelectedItem().toString(), day.getSelectedItem().toString());
        String[] data = {date, limit.toString(), weight.toString()};
        return data;
    }

    @Override
    public void setData(Object[] model) {
    }
}
