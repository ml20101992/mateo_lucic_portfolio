package Controllers;

import Models.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ViewController implements ActionListener {
    private MainContainer main;


    public ViewController(){
        main = new MainContainer();
        View fw = new FirstView();
        fw.registerListeners(this);

        main.addView(fw);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        switch(e.getActionCommand()){
            case "continue":{
                Object[] data = main.getData();
                Injector.getLogController().setDate((String)(data[0]));
                Injector.getLogController().setCalories(Double.parseDouble((String)data[2]));
                Injector.getLogController().setWeight(Double.parseDouble((String)data[1]));
                Injector.getLogController().initDay();

                View v = new MainView();
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "default":{
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                String date = sdf.format(cal.getTime());

                Injector.getLogController().setDate(date);
                Injector.getLogController().setCalories(2000);
                Injector.getLogController().setWeight(150);
                Injector.getLogController().initDay();

                View v = new MainView();
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "Add":{
                View v = new AddEntryChoice();
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "add_food_entry":{
                View v = new AddEntry("food");
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "add_recipe_entry":{
                View v = new AddEntry("recipe");
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "add_exercise_entry":{
                View v = new AddEntry("exercise");
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "AddFood":{
                Object[] data = main.getData();
                String name = (String)data[0];
                double calories = Double.parseDouble((String)data[1]);
                double fat = Double.parseDouble((String)data[2]);
                double carbs = Double.parseDouble((String) data[3]);
                double proteins = Double.parseDouble((String)data[4]);

                BasicFood basic = new BasicFood(name,calories,fat,carbs,proteins);

                Injector.getFoodController().addEntry(basic);

            }break;

            case "AddRecipe":{
                Object[] data = main.getData();
                String name = (String)data[0];
                ArrayList<String> names = (ArrayList<String>)data[1];
                ArrayList<Double> amounts = (ArrayList<Double>)data[2];

                Recipe r = new Recipe(name,names,amounts);
                Injector.getRecipeController().addEntry(r);

            }break;

            case "AddExercise":{
                Object[] data = main.getData();

                Exercise exercise = new Exercise((String)data[0],Double.parseDouble((String)data[1]));
                Injector.getExerciseController().addExercise(exercise);
            }break;

            case "Modify":{
                View v = new ModifyEntryChoice();
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "modify_food_record":{
                View v = new ModifyEntry("food");
                v.registerListeners(this);

                main.addView(v);
            }break;

            case "modify_exercise_record":{
                View v = new ModifyEntry("exercise");
                v.registerListeners(this);

                main.addView(v);
            }break;

            case "modify_recipe_record":{
                View v = new ModifyEntry("recipe");
                v.registerListeners(this);

                main.addView(v);
            }break;

            case "View Log":{
                View v = new ModifyEntry("log");
                v.registerListeners(this);

                main.addView(v);
            }break;

            case "Add Activity":{
                View v = new AddActivity();
                v.registerListeners(this);
                main.addView(v);
            }break;

            case "add_activity_exercise":{
                Object[] data = main.getData();

                String exerciseName = (String)data[2];
                double value = Double.parseDouble((String)data[3]);
                String date = Injector.getLogController().getDate();

                Models.Log log = new Models.Log(String.format("%s,e,%s,%.1f",date,exerciseName,value));

                Injector.getLogController().addLogEntry(log);
            }break;

            case "add_activity_food":{
                Object[] data = main.getData();

                String foodName = (String)data[0];
                double amt = Double.parseDouble((String) data[1]);
                String date = Injector.getLogController().getDate();
                Models.Log log = new Models.Log(String.format("%s,f,%s,%.1f",date,foodName,amt));

                Injector.getLogController().addLogEntry(log);
            }break;

            default:{
                String[] command = e.getActionCommand().split("_");

                switch(command[0]){
                    case "Delete":deleteEntry(command[1],Integer.parseInt(command[2]));
                    break;
                    case "Select":displayLogOverview(command[2],false);
                    break;
                    case "DeleteLog": deleteLogEntry(command[1],command[2],Integer.parseInt(command[3]));
                    break;
                    case "Modify":modifyEntry(command[1]);
                    break;
                    case "Edit":createEditDialog(command[1],Integer.parseInt(command[2]));
                    break;
                }
            }break;
        }
    }

    private void createEditDialog(String type, int id){
        View v = new ModifySingleEntry(type);
        Object[] o = new Object[1];

        ArrayList<Entry> collection = null;

        switch(type){
            case "food":{
                collection = Injector.getFoodController().getFoods();
            }break;

            case "recipe":{
                collection = Injector.getRecipeController().getRecipes();
            }break;

            case "exercise":{
                collection = Injector.getExerciseController().getExercises();
            }break;
        }

        o[0] = collection.get(id);

        v.setData(o);
        v.registerListeners(this);
        main.addView(v);
    }

    private void modifyEntry(String type){
        Object[] o = main.getData();

        Entry e = (Entry)o[0];

        switch (type){
            case "food":{
                String name = (String)o[1];
                double calories = Double.parseDouble((String)o[2]);
                double fat = Double.parseDouble((String)o[3]);
                double carbs = Double.parseDouble((String)o[4]);
                double prot = Double.parseDouble((String)o[5]);

                BasicFood f = new BasicFood(name,calories,fat,carbs,prot);

                Injector.getFoodController().modifyEntry((BasicFood)e,f);
            }break;
            case "exercise":{
                String name = (String)o[1];
                Double value = Double.parseDouble((String)o[2]);

                Exercise ex = new Exercise(name,value);

                Injector.getExerciseController().modifyExercise((Exercise)e,ex);
            }break;

            case "recipe":{
                String name = e.getName();
                ArrayList<String> names = (ArrayList<String>)o[1];
                ArrayList<Double> values = (ArrayList<Double>)o[2];

                Recipe r = new Recipe(name,names,values);

                Injector.getRecipeController().modifyEntry((Recipe)e,r);
            }break;
        }
    }

    private void deleteLogEntry(String entryType, String date, int id){
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        LogController lc = Injector.getLogController();
        ArrayList<Log> entries = null;

        if(entryType.equals("f")) entries = lc.getFoodsOnDay(year,month,day);
        else entries = lc.getExercisesOnDay(year,month,day);
        Log l = entries.get(id);

        lc.deleteLogEntry(l);

        displayLogOverview(date,true);

    }

    private void deleteEntry(String type,int id){
        Object[] data = main.getData();
        //Entry entry =  ((ArrayList<Entry>)data[0]).get(id);

        if(type.equals("food")){
            Injector.getFoodController().removeEntry(id);
        }
        else if(type.equals("exercise")){
            Injector.getExerciseController().deleteExercise(id);
        }
        else{
            Injector.getRecipeController().deleteEntry(id);
        }

        View v = new ModifyEntry(type);
        v.registerListeners(this);

        main.refresh(v);
    }

    private void displayLogOverview(String date, boolean reload){
        String[] split = date.split("-");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LogController lc = Injector.getLogController();

        ArrayList<Log> foods = lc.getFoodsOnDay(year,month,day);
        ArrayList<Object[]> preparedFoods = new ArrayList<>();

        for(Log l: foods){
            preparedFoods.add(prepareFood(l));
        }

        ArrayList<Log> exercises = lc.getExercisesOnDay(year,month,day);
        ArrayList<Object[]> preparedExercises = new ArrayList<>();

        for(Log l: exercises){
            preparedExercises.add(prepareExercises(l));
        }


        double[] graphData = new double[]{lc.getTotals(2),lc.getTotals(3),lc.getTotals(4)};
        Object[] data = new Object[]{preparedFoods,preparedExercises, new double[]{lc.getCaloriesConsumed(),lc.getCaloriesExpended(),lc.getNetCalories()},graphData};

        View v = new DisplayLog(date);
        v.setData(data);
        v.registerListeners(this);

        if(reload) main.refresh(v);
        else main.addView(v);
    }

    private Object[] prepareFood(Log l){
        String name = l.getName();
        double calories = Injector.getLogController().getSingularIntakeCal(name);

        return new Object[]{name,calories,l.getValue()};
    }

    private Object[] prepareExercises(Log l){
        String name = l.getName();
        double calories = Injector.getLogController().getSingularExpenditureCal(name);

        return new Object[]{name,calories,l.getValue()};
    }
}
