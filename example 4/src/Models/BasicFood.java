package Models;

public class BasicFood implements Entry {
    private String type = "b";
    private String name = "";
    private double calories,fat,carb,protein;

    public BasicFood(String name, double calories, double fat, double carb, double protein) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carb = carb;
        this.protein = protein;
    }

    public BasicFood(String entry){
        this.name = entry.split(",")[1];
        this.calories = Double.parseDouble(entry.split(",")[2]);
        this.fat = Double.parseDouble(entry.split(",")[3]);
        this.carb = Double.parseDouble(entry.split(",")[4]);
        this.protein = Double.parseDouble(entry.split(",")[2]);
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
        return new Object[]{name,calories,fat,carb,protein};
    }

    @Override
    public String toFileFormat() {
        return String.format("b,%s,%.1f,%.1f,%.1f,%.1f",name,calories,fat,carb,protein);
    }
}
