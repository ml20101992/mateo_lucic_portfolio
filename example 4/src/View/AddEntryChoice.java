package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by User on 4/25/2018.
 */
public class AddEntryChoice implements View{

    private JPanel view;
    private String title;
    private String[] data;
    private JButton addFoodBtn, addRecipeBtn, addExerciseBtn;
    private Font roboto = new Font("Roboto Condensed", Font.PLAIN, 14);

    public AddEntryChoice() {

        this.title = "Choose Action";
        //TODO napravi subview koji vodi na dodavanje hrane, recepta ili exercisea
        addFoodBtn = createButton("Add Food Entry", "add_food_entry");
        addRecipeBtn = createButton("Add Recipe Entry", "add_recipe_entry");
        addExerciseBtn = createButton("Add Exercise Entry", "add_exercise_entry");

        view = new JPanel();
        view.add(addFoodBtn);
        view.add(addRecipeBtn);
        view.add(addExerciseBtn);

    }//end of AddEntryChoice()

    /**
     * Creates a custom JButton object
     * @param title Button title
     * @param command Button ActionCommand
     * @return Custom JButton object
     */
    private JButton createButton(String title, String command) {
        JButton btn = new JButton(title);
        btn.setActionCommand(command);
        btn.setFont(roboto);
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(150, 28));
        btn.setBorder(new LineBorder(Color.BLACK));

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
        addRecipeBtn.addActionListener(listener);
    }

    @Override
    public String[] getData() {
        return this.data;
    }

    @Override
    public void setData(Object[] model) {}

}//end of AddEntryChoice class