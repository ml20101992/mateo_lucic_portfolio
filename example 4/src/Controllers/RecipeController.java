package Controllers;

import Models.BasicFood;
import Models.Entry;
import Models.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeController {
    private HashMap<String, Recipe> recipes;

    public RecipeController(){
        recipes = new HashMap<>();
        populateInternalData();
    }

    private void populateInternalData(){
        ArrayList<Entry> data = Injector.getReader().readRecipes();

        for(Entry e: data){
            recipes.put(e.getName(),(Recipe)e);
        }
    }

    public Recipe getRecipeByName(String name){
        if(recipes.containsKey(name)) return recipes.get(name);
        else return null;
    }

    public boolean addEntry(Recipe r){
        Object[] data = r.getData();

        boolean check = true;                       //check if the required foods exist in food map
        for(String s : (ArrayList<String>)data[0]){
            if(!Injector.getFoodController().checkIfFoodExists(s)) check = false;
        }

        if(!check) return false;                    //if they dont exist, exit

        recipes.put(r.getName(),r);
        ArrayList<String> stringData = Injector.getReader().readStringData("foods.csv");
        stringData.add(r.toFileFormat());
        Injector.getReader().writeStrings("foods.csv",stringData);
        return true;
    }

    public ArrayList<Entry> getRecipes(){
        return Injector.getReader().readRecipes();
    }

    public void modifyEntry(Recipe oldEntry, Recipe modified){
        for(String key: recipes.keySet()){
            if(recipes.get(key).equals(oldEntry)){
                recipes.replace(key,oldEntry,modified);
            }
        }

        Injector.getReader().modifyEntry("foods.csv",oldEntry,modified);

    }

    public void deleteEntry(int index){
        ArrayList<Entry> recipesList = Injector.getReader().readRecipes();

        recipes.remove(recipesList.get(index).getName());

        Injector.getReader().deleteEntry("foods.csv",recipesList.get(index));
    }

    public double getTotalsByName(String name, int selector) {
        Recipe r = recipes.get(name);

        return r.getTotals(selector);
    }

    public void purgeRecipesByFoodName(String name){
        String k = "";
        Recipe r = null;
        for(String key: recipes.keySet()){
            Recipe temp = recipes.get(key);

            if(temp.checkForFoodName(name)){
                k = key;
                r = temp;
            }
        }

        if(r != null) {
            ArrayList<Entry> entries = getRecipes();
            int index = 0;

            for (int i = 0; i < entries.size(); i++) {
                Recipe rec = (Recipe) entries.get(i);
                if ((rec.getName()).equals(r.getName())) index = i;
            }

            deleteEntry(index);
            recipes.remove(k);

        }

    }


}
