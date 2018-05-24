package Models;

public class Exercise implements Entry {
    private String type = "e";
    private String name;
    private double calories;

    public Exercise(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public Exercise(String entry){
        this.name = entry.split(",")[1];
        this.calories = Double.parseDouble(entry.split(",")[2]);
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
        return new Double[]{calories};
    }

    @Override
    public String toFileFormat() {
        return String.format("e,%s,%.1f", name, calories);
    }
}
