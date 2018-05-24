package View;

import Controllers.Injector;
import Models.Entry;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/25/2018.
 */
public class ModifyEntry implements View{

    private String type, title;
    private JPanel view;
    private Font roboto = new Font("Roboto Condensed", Font.PLAIN, 14);
    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<Entry> loadedEntries;

    public ModifyEntry(String type) {


        this.title = "Modify Entry";
        this.type = type;
        this.view = new JPanel();
        JLabel error = new JLabel("No Records Found.");
        error.setForeground(Color.RED);
        error.setFont(View.roboto);
        switch(type) {
            case "food":
                ArrayList<Entry> foodEntries = Injector.getFoodController().getFoods();
                loadedEntries = foodEntries;

                if(foodEntries.size() < 1) {
                    view.add(error);
                }
                else {
                    for (Entry entry : foodEntries) {
                        createEntryData(entry, foodEntries.indexOf(entry));
                    }
                }

                break;
            case "recipe":
                ArrayList<Entry> recipeEntries = Injector.getRecipeController().getRecipes();
                loadedEntries = recipeEntries;

                if(recipeEntries.size() < 1) {
                    view.add(error);
                }
                else {
                    for (Entry entry : recipeEntries) {
                        createEntryData(entry, recipeEntries.indexOf(entry));
                    }
                }

                break;
            case "exercise":
                ArrayList<Entry> exerciseEntries = Injector.getExerciseController().getExercises();
                loadedEntries = exerciseEntries;

                if(exerciseEntries.size() < 1) {
                    view.add(error);
                }

                else {
                    for (Entry entry : exerciseEntries) {
                        createEntryData(entry, exerciseEntries.indexOf(entry));

                    }
                }

                break;

            case "log":{
                ArrayList<String> dates = Injector.getLogController().getLogDates();

                if(dates.size() < 1){
                    view.add(error);
                }

                else{
                    for(String date: dates){
                        createLogData(date);
                    }
                }
            }break;
        }
    }//end of ModifyEntry()

    private void createEntryData(Entry entry, int id) {
        JPanel panel = new JPanel();
        panel.setFont(roboto);
        JLabel entryNameLabel = new JLabel("Entry Name:");
        JLabel entryNameValue = new JLabel(entry.getName());
        panel.add(entryNameLabel);
        panel.add(entryNameValue);

        panel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));

        JButton deleteRecord = createButton("Delete", id+"");
        JButton editRecord = createButton("Edit", id+"");

        buttons.add(deleteRecord);
        buttons.add(editRecord);

        panel.add(deleteRecord);
        panel.add(editRecord);
        panel.setPreferredSize(new Dimension(581, 75));
        this.view.add(panel);
    }

    private void createLogData(String date){
        JPanel panel = new JPanel();
        panel.setFont(roboto);
        JLabel entryNameLabel = new JLabel("Log Date:");
        JLabel entryNameValue = new JLabel(date);
        panel.add(entryNameLabel);
        panel.add(entryNameValue);

        panel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));

        JButton deleteRecord = createButton("Select",date);

        buttons.add(deleteRecord);
        buttons.add(deleteRecord);

        panel.add(deleteRecord);
        panel.setPreferredSize(new Dimension(581, 75));
        this.view.add(panel);
    }

    private JButton createButton(String title, String id) {
        JButton btn = new JButton(title);
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(80, 26));
        btn.setFont(roboto);
        btn.setAlignmentX(FlowLayout.RIGHT);
        btn.setBorder(new LineBorder(Color.BLACK));
        btn.setActionCommand(title + "_" + this.type + "_" + id);

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
        for(JButton button: buttons){
            button.addActionListener(listener);
        }
    }

    @Override
    public Object[] getData() {
        return new Object[]{loadedEntries};
    }

    @Override
    public void setData(Object[] model) {

    }
}//end of ModifyEntry class
