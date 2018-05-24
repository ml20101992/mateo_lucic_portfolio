package View;

import Models.Entry;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/27/2018.
 */
public class ModifySingleEntry implements View {


    private JLabel nameLabel, nameValueLabel, exerciseNameValue;
    private JTextField caloriesInput, fatInput, carbInput, proteinsInput, exerciseCalorieInput;
    private JPanel view;
    private String title, type;
    private JButton saveBtn;
    private Entry oldEntry;
    private JLabel recipeNameValue;
    private ArrayList<JTextField> newValues = new ArrayList<>();
    private Font robotoBold = new Font("Roboto Condensed", Font.BOLD, 18);
    private Font robotoPlain = new Font("Roboto Condensed", Font.PLAIN, 13);

    public ModifySingleEntry(String type) {

        view = new JPanel();
        this.type = type;

        switch(this.type) {
            case "food":
                this.title = "Add Food Entry";
                this.view = new JPanel(new GridLayout(0,1, 15, 45));

                JPanel namePanel = new JPanel(new GridLayout(1, 2));
                nameLabel = new JLabel("Food name:");
                nameLabel.setFont(robotoBold);
                nameValueLabel = new JLabel("");
                nameValueLabel.setFont(robotoPlain);
                namePanel.add(nameLabel);
                namePanel.add(nameValueLabel);

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
                this.view.setPreferredSize(new Dimension(300, 400));
                this.view.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                JLabel recipeNameLabel = new JLabel("Recipe Name:");
                recipeNameLabel.setFont(robotoBold);
                recipeNameValue = new JLabel("");
                recipeNameValue.setFont(View.roboto);

                view.add(recipeNameLabel);
                view.add(recipeNameValue);


                break;
            case "exercise":
                this.title = "Modify Exercise";
                this.view = new JPanel(new GridLayout(0,1));

                JPanel exerciseWrapper = new JPanel(new GridLayout(2, 1, 10, 25));
                JPanel exerciseUpperPanel = new JPanel();

                JLabel exerciseNameLabel = new JLabel("Exercise name:");
                exerciseNameLabel.setFont(robotoBold);

                exerciseNameValue = new JLabel("");
                exerciseNameValue.setFont(robotoPlain);

                exerciseUpperPanel.add(exerciseNameLabel);
                exerciseUpperPanel.add(exerciseNameValue);

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
        }//end of switch
        saveBtn = new JButton("Save");
        saveBtn.setBackground(Color.WHITE);
        saveBtn.setBorder(new LineBorder(Color.BLACK));
        saveBtn.setPreferredSize(new Dimension(120, 40));
        this.view.add(saveBtn);

    }//end of ModifySingleEntry()

    /**
     * Creates a list of all basic foods in a recipe record
     * @param name Basic food name
     * @param amount Basic food amount in the recipe
     * @return JPanel with custom data
     */
    private JPanel createRecipeModification(String name, String amount) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 100));
        panel.setFont(roboto);

        JLabel basicFood = new JLabel(name);
        panel.add(basicFood);

        JLabel chngAmount = new JLabel("Change amount:");
        panel.add(chngAmount);
        JTextField newAmountValue = new JTextField(5);
        newValues.add(newAmountValue);
        newAmountValue.setText(amount);
        panel.add(newAmountValue);
        return panel;
    }//end of createRecipeModification()

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
        saveBtn.addActionListener(listener);
        switch(this.type) {
            case "food":
                saveBtn.setActionCommand("Modify_food_record");
                break;
            case "recipe":
                saveBtn.setActionCommand("Modify_recipe_record");
                break;
            case "exercise":
                saveBtn.setActionCommand("Modify_exercise_record");
                break;
        }
    }//end of registerListeners()

    @Override
    public Object[] getData() {

        Object[] finalData = null;

        switch(this.type) {
            case "food":
                finalData = new Object[]{this.oldEntry, this.nameValueLabel.getText(), this.caloriesInput.getText(), this.fatInput.getText(), this.carbInput.getText(), this.proteinsInput.getText() };
                break;
            case "recipe":
                ArrayList<Double> newValues = new ArrayList<>();

                for(int i = 0; i< this.newValues.size(); i++){
                    newValues.add(Double.parseDouble(this.newValues.get(i).getText()));
                }
                finalData = new Object[]{this.oldEntry,oldEntry.getData()[0],newValues};
                break;
            case "exercise":
                finalData = new Object[]{this.oldEntry, this.exerciseNameValue.getText(), this.exerciseCalorieInput.getText()};
                break;
        }//end of switch

        return finalData;
    }//end of getData()

    @Override
    public void setData(Object[] model) {

        oldEntry = (Entry)model[0];
        Object[] data = oldEntry.getData();

        switch(this.type){
            case "food":
                nameValueLabel.setText(oldEntry.getName());
                caloriesInput.setText((double)data[1]+"");
                carbInput.setText((double)data[3]+"");
                fatInput.setText((double)data[2]+"");
                proteinsInput.setText((double)data[4]+"");
                break;
            case "recipe":
                ArrayList<String> oldEntryNames = (ArrayList<String>)oldEntry.getData()[0];
                ArrayList<Double> oldEntryAmounts = (ArrayList<Double>)oldEntry.getData()[1];
                recipeNameValue.setText(oldEntry.getName());
                //add all basic foods in a recipe to be modified
                for(int i = 0; i < oldEntryNames.size(); i++) {
                    JPanel panel = createRecipeModification(oldEntryNames.get(i), oldEntryAmounts.get(i)+"");
                    view.add(panel);
                }

                break;
            case "exercise":
                exerciseNameValue.setText(oldEntry.getName());
                exerciseCalorieInput.setText((double)oldEntry.getData()[0]+"");
                break;
        }//end of switch

    }//end of setData()

}//end of ModifySingleEntry class
