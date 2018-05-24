package View;

import Controllers.Injector;
import Models.Entry;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/26/2018.
 */
public class AddActivity implements View{

    private String title;
    private JPanel view;
    private JButton addExerciseBtn, addFoodBtn;
    private JComboBox<String> foodChoice,exerciseChoice;
    private JTextField portionsValue, durationValue;
    public AddActivity() {

        this.title = "Add Activity";
        this.view = new JPanel();

        addFoodActivity();
        addExerciseActivity();

    }

    private void addFoodActivity(){

        JPanel foodPanel = new JPanel();
        foodPanel.setFont(View.roboto);
        foodPanel.setPreferredSize(new Dimension(200, 400));
        foodPanel.setBorder(BorderFactory.createMatteBorder(0,1,0,2, Color.BLACK));

        ArrayList<Entry> foodEntries = Injector.getRecipeController().getRecipes();

        JLabel foodName = new JLabel("Select Food:");
        foodChoice = new JComboBox<>();
        for(Entry entry : foodEntries) {
            foodChoice.addItem(entry.getName());
        }

        foodChoice.setPreferredSize(new Dimension(160, 25));

        foodPanel.add(foodName);
        foodPanel.add(foodChoice);

        JLabel portionsLabel = new JLabel("Portion(s) eaten:     ");
        portionsValue = new JTextField(8);
        portionsValue.setPreferredSize(new Dimension(60, 25));

        foodPanel.add(portionsLabel);
        foodPanel.add(portionsValue);

        addFoodBtn = createButton("Add", "add_activity_food");
        foodPanel.add(addFoodBtn);

        if(foodEntries.size() < 1) {
            addFoodBtn.setEnabled(false);
            foodChoice.addItem("No food found.");
        }
        else {
            addFoodBtn.setEnabled(true);
            for (Entry entry : foodEntries) {
                foodChoice.addItem(entry.getName());
            }
        }

        this.view.add(foodPanel);
    }//end of addFoodActivity()

    /**
     *
     */
    private void addExerciseActivity() {

        JPanel exercisePanel = new JPanel();
        exercisePanel.setFont(View.roboto);
        exercisePanel.setPreferredSize(new Dimension(200, 400));
        exercisePanel.setBorder(BorderFactory.createMatteBorder(0,0,0,1, Color.BLACK));

        ArrayList<Entry> exerciseEntries = Injector.getExerciseController().getExercises();

        JLabel exerciseNameLabel = new JLabel("Select Exercise:");
        exerciseChoice = new JComboBox<>();

        exerciseChoice.setPreferredSize(new Dimension(160, 25));

        exercisePanel.add(exerciseNameLabel);
        exercisePanel.add(exerciseChoice);

        JLabel exerciseDurationLabel = new JLabel("Minutes exercised:");
        durationValue = new JTextField(10);
        durationValue.setPreferredSize(new Dimension(60, 25));

        exercisePanel.add(exerciseDurationLabel);
        exercisePanel.add(durationValue);

        addExerciseBtn = createButton("Add Exercise", "add_activity_exercise");
        exercisePanel.add(addExerciseBtn);

        if(exerciseEntries.size() < 1) {
            exerciseChoice.addItem("No exercises found.");
            addExerciseBtn.setEnabled(false);
        }
        else {
            addExerciseBtn.setEnabled(true);
            for (Entry entry : exerciseEntries) {
                exerciseChoice.addItem(entry.getName());
            }
        }

        this.view.add(exercisePanel);
    }//end of addExerciseActivity

    private JButton createButton(String title, String command) {
        JButton btn = new JButton(title);
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(110, 30));
        btn.setFont(View.roboto);
        btn.setBorder(new LineBorder(Color.BLACK));
        btn.setActionCommand(command);

        return btn;
    }

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
        addExerciseBtn.addActionListener(listener);
        addFoodBtn.addActionListener(listener);
    }

    @Override
    public Object[] getData() {

        return new Object[]{foodChoice.getSelectedItem(),portionsValue.getText(),exerciseChoice.getSelectedItem(),durationValue.getText()};
    }

    @Override
    public void setData(Object[] model) {

    }
}
