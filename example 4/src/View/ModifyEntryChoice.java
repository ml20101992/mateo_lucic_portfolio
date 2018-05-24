package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by User on 4/26/2018.
 */
public class ModifyEntryChoice implements View {

    private JPanel view;
    private String title;
    private String[] data;
    private JButton modifyFoodBtn, modifyRecipeBtn, modifyExerciseBtn;

    public ModifyEntryChoice(){
        this.title = "Choose Action";

        this.view = new JPanel();
        //create Buttons
        modifyFoodBtn = createButton("Modify Food", "modify_food_record");
        modifyRecipeBtn = createButton("Modify Recipe", "modify_recipe_record");
        modifyExerciseBtn = createButton("Modify Exercise", "modify_exercise_record");

        //add buttons to panel
        view.add(modifyFoodBtn);
        view.add(modifyRecipeBtn);
        view.add(modifyExerciseBtn);
    }

    /**
     * Creates a custom JButton object
     * @param title Button title
     * @param command Button ActionCommand
     * @return Custom JButton object
     */
    private JButton createButton(String title, String command) {
        JButton btn = new JButton(title);
        btn.setActionCommand(command);
        btn.setFont(View.roboto);
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(150, 28));
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
        modifyFoodBtn.addActionListener(listener);
        modifyExerciseBtn.addActionListener(listener);
        modifyRecipeBtn.addActionListener(listener);
    }

    @Override
    public Object[] getData() {
        return this.data;
    }

    @Override
    public void setData(Object[] model) {

    }
}
