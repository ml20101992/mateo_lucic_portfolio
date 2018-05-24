package Models;

import Controllers.Injector;

import java.util.ArrayList;

public class Recipe implements Entry {
    private String type = "f";
    private String name;

    public Recipe(String name, ArrayList<String> foodNames, ArrayList<Double> foodAmount) {
        this.name = name;
        this.foodNames = foodNames;
        this.foodAmount = foodAmount;
    }

    private ArrayList<String> foodNames = new ArrayList<>();
    private ArrayList<Double> foodAmount = new ArrayList<>();

    public Recipe(String entry){
        String[] data = entry.split(",");
        int entrySize = data.length;

        this.name = data[1];

        for(int i = 2; i< entrySize; i+=2){
            foodNames.add(data[i]);
            foodAmount.add(Double.parseDouble(data[i+1]));
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Object[] getData() {
        return new ArrayList[]{foodNames,foodAmount};
    }

    @Override
    public String toFileFormat() {
        String retVal = String.format("f,%s",name);
        for(int i=0; i< foodNames.size(); i++){
            retVal += String.format(",%s,%.2f",foodNames.get(i),foodAmount.get(i));
        }

        return retVal;
    }

    public double getTotalCalories(){
        double calories = 0;

        for(int i=0; i< foodNames.size(); i++){
            BasicFood f = Injector.getFoodController().getBasicFoodByName(foodNames.get(i));
            calories += (Double)f.getData()[1] * foodAmount.get(i);
        }

        return calories;
    }

    /**
     * 0 - name - DONT USE
     * 1 - carbs
     * 2 - fats
     * 3 - carbs
     * 4 - protein
     * @param selector
     * @return
     */
    public double getTotals(int selector){
        double totals = 0;

        for(int i=0; i< foodNames.size(); i++){
            BasicFood f = Injector.getFoodController().getBasicFoodByName(foodNames.get(i));
            totals += (Double)f.getData()[selector] * foodAmount.get(i);
        }

        return totals;
    }

    public boolean checkForFoodName(String name){
        for(String n: foodNames){
            if (n.equals(name)) return true;
        }

        return false;
    }
}
