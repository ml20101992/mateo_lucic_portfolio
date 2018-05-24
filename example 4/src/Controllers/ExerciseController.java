package Controllers;

import Models.Entry;
import Models.Exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class ExerciseController {
    private HashMap<String, Exercise> exercises;

    public ExerciseController(){
        exercises = new HashMap<>();
        populateInternalData();
    }
    public Exercise getExerciseByName(String name){
        return exercises.get(name);
    }
    private void populateInternalData(){
        ArrayList<Entry> exercises = Injector.getReader().readExercises();

        for(Entry e: exercises){
            this.exercises.put(e.getName(),(Exercise)e);
        }
    }

    public ArrayList<Entry> getExercises(){
        return Injector.getReader().readExercises();
    }

    public void addExercise(Exercise e){
        exercises.put(e.getName(),e);
        ArrayList<String> strings = Injector.getReader().readStringData("exercises.csv");
        strings.add(e.toFileFormat());

        Injector.getReader().writeStrings("exercises.csv",strings);
    }

    public void modifyExercise(Exercise oldExercise, Exercise newExercise){

        for(String key: exercises.keySet()){
            if(exercises.get(key).equals(oldExercise)){
                exercises.replace(key,oldExercise,newExercise);
            }
        }

        Injector.getReader().modifyEntry("exercises.csv",oldExercise,newExercise);
    }

    public void deleteExercise(int index){
        ArrayList<Entry> exercises = Injector.getReader().readExercises();

        this.exercises.remove(exercises.get(index).getName());

        Injector.getReader().deleteEntry("exercises.csv",exercises.get(index));
    }


}
