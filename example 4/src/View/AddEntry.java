package View;

import javax.swing.*;
import Controllers.*;
import Models.Entry;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/25/2018.
 */
public class AddEntry implements View {

    private JPanel view, btnPanel;
    private String type, title;
    private JButton save;
    private ArrayList<String> names;
    private ArrayList<Double> amounts;
    private JLabel nameLabel;
    private JTextField amountValue, exerciseNameInput, exerciseCalorieInput, fatInput, carbInput, caloriesInput, proteinsInput, nameInput, recipeNameValue;
    private JComboBox<String> foodCombo;
    private Font robotoBold = new Font("Roboto Condensed", Font.BOLD, 18);
    private Font robotoPlain = new Font("Roboto Condensed", Font.PLAIN, 13);


    public AddEntry(String type) {

        this.type = type;
        btnPanel = new JPanel();

        switch (this.type) {
            case "food":
                this.title = "Add Food Entry";
                this.view = new JPanel(new GridLayout(0,1, 15, 45));

                JPanel namePanel = new JPanel(new GridLayout(1, 2));
                nameLabel = new JLabel("Food name:");
                nameLabel.setFont(robotoBold);
                nameInput = new JTextField(10);
                nameInput.setFont(robotoPlain);
                namePanel.add(nameLabel);
                namePanel.add(nameInput);

                JPanel caloriesPanel = new JPanel(new GridLayout(1, 2));
                JLabel caloriesLabel = new JLabel("Calories:");
                caloriesLabel.setFont(robotoBold);
                caloriesInput = new JTextField(10);
                caloriesInput.setFont(robotoPlain);
                caloriesPanel.add(caloriesLabel);
                caloriesPanel.add(caloriesInput);

                JPanel fatPanel = new JPanel(new GridLayout(1, 2));
                JLabel fatLabel = new JLabel("Fat:");
                fatLabel.setFont(robotoBold);
                fatInput = new JTextField(10);
                fatInput.setFont(robotoPlain);
                fatPanel.add(fatLabel);
                fatPanel.add(fatInput);

                JPanel carbPanel = new JPanel(new GridLayout(1, 2));
                JLabel carbLabel = new JLabel("Carbs:");
                carbLabel.setFont(robotoBold);
                carbInput = new JTextField(10);
                carbInput.setFont(robotoPlain);
                carbPanel.add(carbLabel);
                carbPanel.add(carbInput);

                JPanel proteinPanel = new JPanel(new GridLayout(1, 2));
                JLabel proteinsLabel = new JLabel("Proteins:");
                proteinsLabel.setFont(robotoBold);
                proteinsInput = new JTextField(10);
                proteinsInput.setFont(robotoPlain);
                proteinPanel.add(proteinsLabel);
                proteinPanel.add(proteinsInput);

                this.view.add(namePanel);
                this.view.add(caloriesPanel);
                this.view.add(fatPanel);
                this.view.add(carbPanel);
                this.view.add(proteinPanel);

                break;
            case "recipe":
                names = new ArrayList<>();
                amounts = new ArrayList<>();

                this.view = new JPanel();
                this.title = "Add Recipe";

                ArrayList<Entry> foods = Injector.getFoodController().getFoods();

                JPanel dataPanel = new JPanel(new GridLayout(3,1, 5, 20));
                JPanel recipeNamePanel = new JPanel();
                JLabel recipeNameLabel = new JLabel("Recipe Name:");
                recipeNameLabel.setFont(robotoBold);
                recipeNameValue = new JTextField(15);
                recipeNameValue.setFont(robotoPlain);
                recipeNamePanel.add(recipeNameLabel);
                recipeNamePanel.add(recipeNameValue);
                view.add(recipeNamePanel);

                JPanel nameChoicePanel = new JPanel();
                nameLabel = new JLabel("Name:");
                nameLabel.setFont(robotoBold);

                foodCombo = new JComboBox<>();
                foodCombo.setFont(robotoPlain);
                foodCombo.setPreferredSize(new Dimension(140, 25));
                for(Entry food : foods) {
                    foodCombo.addItem(food.getName());
                }

                nameChoicePanel.add(nameLabel);
                nameChoicePanel.add(foodCombo);

                JPanel amountChoicePanel = new JPanel();
                JLabel amountLabel = new JLabel("Amount:");
                amountLabel.setFont(robotoBold);

                amountValue = new JTextField(5);
                amountValue.setPreferredSize(new Dimension(100, 25));
                amountValue.setText("1.0");

                amountChoicePanel.add(amountLabel);
                amountChoicePanel.add(amountValue);

                dataPanel.add(nameChoicePanel);
                dataPanel.add(amountChoicePanel);
                this.view.add(dataPanel);

                JButton addAnotherBtn = createButton("Add Another");
                addAnotherBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //check if any basic foods exist in the entry list that the user hasn't used
                        if(foodCombo.getSelectedItem().toString().equals("No Food Available.")) {
                            //display error message; stop user from adding more food
                            JOptionPane.showMessageDialog(null, "You added all food available.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            names.add(foodCombo.getSelectedItem().toString());
                            amounts.add(Double.parseDouble(amountValue.getText()));
                            foods.remove(foodCombo.getSelectedIndex());
                            foodCombo.removeAllItems();
                            if (foods.size() < 1) {
                                foodCombo.addItem("No Food Available.");
                            } else {
                                for (Entry food : foods) {
                                    foodCombo.addItem(food.getName());
                                }
                            }
                        }
                        foodCombo.setSelectedIndex(0);
                        amountValue.setText("1.0");
                    }
                });//addAnotherButton event listener

                btnPanel.add(addAnotherBtn);
                break;
            case "exercise":
                this.title = "Add Exercise";
                this.view = new JPanel(new GridLayout(0,1));

                JPanel exerciseWrapper = new JPanel(new GridLayout(2, 1, 10, 25));
                JPanel exerciseUpperPanel = new JPanel();

                JLabel exerciseNameLabel = new JLabel("Exercise name:");
                exerciseNameLabel.setFont(robotoBold);

                exerciseNameInput = new JTextField(10);
                exerciseNameInput.setPreferredSize(new Dimension(100, 25));
                exerciseNameInput.setFont(robotoPlain);

                exerciseUpperPanel.add(exerciseNameLabel);
                exerciseUpperPanel.add(exerciseNameInput);

                JPanel exerciseLowerPanel = new JPanel();

                JLabel exerciseCalorieLabel = new JLabel("Calorie consumption:");
                exerciseCalorieLabel.setFont(robotoBold);

                exerciseCalorieInput = new JTextField(10);
                exerciseCalorieInput.setFont(robotoPlain);

                exerciseLowerPanel.add(exerciseCalorieLabel);
                exerciseLowerPanel.add(exerciseCalorieInput);

                exerciseWrapper.add(exerciseUpperPanel);
                exerciseWrapper.add(exerciseLowerPanel);

                view.add(exerciseWrapper);

                break;
            default: break;
        }//end of switch

        save = createButton("Save");
        btnPanel.add(save);

        this.view.add(btnPanel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(this.view);
    }//end of AddEntry()

    /**
     * Creates a custom button
     * @param title Button title
     * @return Custom JButton object
     */
    private JButton createButton(String title) {
        JButton btn = new JButton(title);
        btn.setFont(robotoPlain);
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(150, 30));
        btn.setBorder(new LineBorder(Color.BLACK));
        return btn;
    }//end of createButton()

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public JPanel getView() {
        return this.view;
    }

    @Override
    public void registerListeners(ActionListener listener) {
        save.addActionListener(listener);
        switch(this.type) {
            case "food":
                save.setActionCommand("AddFood");
                break;
            case "recipe":
                save.setActionCommand("AddRecipe");
                break;
            case "exercise":
                save.setActionCommand("AddExercise");
                break;
        }
    }//end of registerListeners()

    @Override
    public Object[] getData() {

        Object[] finalData = null;

        switch(this.type) {
            case "food":
                finalData = new Object[]{this.nameInput.getText(), this.caloriesInput.getText(), this.fatInput.getText(), this.carbInput.getText(), this.proteinsInput.getText() };
                break;
            case "recipe":
                finalData = new Object[]{this.recipeNameValue.getText(), this.names, this.amounts};
                break;
            case "exercise":
                finalData = new Object[]{this.exerciseNameInput.getText(), this.exerciseCalorieInput.getText()};
                break;
        }

        return finalData;
    }//end of getData()

    @Override
    public void setData(Object[] model) {
        switch(this.type) {
            case "food":
                nameLabel.setText("");
                break;
            case "recipe":
                break;
            case "exercise":
                break;
        }//end of switch
    }//end of setData()
}
