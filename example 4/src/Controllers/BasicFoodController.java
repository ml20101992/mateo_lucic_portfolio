package Controllers;

import Models.BasicFood;
import Models.Entry;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicFoodController {
    private HashMap<String, BasicFood> basicFoods;

    public BasicFoodController(){
        this.basicFoods = new HashMap<>();
        populateInternalMemory();
    }

    public BasicFood getBasicFoodByName(String name){
        return basicFoods.get(name);
    }
    public boolean addEntry(BasicFood food){
        if (basicFoods.containsKey(food.getName())) return false;
        else {
            basicFoods.put(food.getName(),food);
            ArrayList<String> stringEntries = Injector.getReader().readStringData("foods.csv");
            stringEntries.add(food.toFileFormat());
            Injector.getReader().writeStrings("foods.csv",stringEntries);
            return true;
        }



    }

    public void removeEntry(int index){
        ArrayList<Entry> foods = getFoods();

        Entry e = foods.get(index);
        basicFoods.remove(foods.get(index).getName());
        foods.remove(index);

        Injector.getRecipeController().purgeRecipesByFoodName(e.getName());
        Injector.getReader().deleteEntry("foods.csv",e);
    }

    public void modifyEntry(BasicFood oldEntry, BasicFood newEntry){

        for(String k: basicFoods.keySet()){
            if(basicFoods.get(k).equals(oldEntry)){
                basicFoods.replace(k,oldEntry,newEntry);
            }
        }

        Injector.getReader().modifyEntry("foods.csv",oldEntry,newEntry);
    }



    private void populateInternalMemory(){
        ArrayList<Entry> foods = getFoods();

        for(Entry food:foods){
            basicFoods.put(food.getName(),(BasicFood)food);
        }
    }

    /**
     * Method used to retrieve foods
     * @return
     */
    public ArrayList<Entry> getFoods(){
        Reader r  = Injector.getReader();

        return r.readFood();
    }

    public boolean checkIfFoodExists(String name){
        return basicFoods.containsKey(name);
    }






}
