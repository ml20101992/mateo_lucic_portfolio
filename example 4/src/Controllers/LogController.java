package Controllers;

import Models.*;

import java.util.ArrayList;

public class LogController {
    private ArrayList<Entry> logEntries;
    private int year,month,day;
    private double calories,weight;

    public int getYear() {
        return year;
    }

    public void setDate(String date){
        String[] d = date.split("-");
        this.year = Integer.parseInt(d[0]);
        this.month = Integer.parseInt(d[1]);
        this.day = Integer.parseInt(d[2]);
    }

    public String getDate(){
        return String.format("%d,%d,%d",year,month,day);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LogController(){
        logEntries = new ArrayList<>();
        logEntries = Injector.getReader().readLog();
    }

    public void addLogEntry(Log l){
        logEntries.add(l);
        Injector.getReader().writeEntry("log.csv",logEntries);
    }

    public void modifyLogEntry(int index, Log modified){
        logEntries.set(index,modified);
        Injector.getReader().writeEntry("log.csv",logEntries);
    }

    public void deleteLogEntry(int index){
        logEntries.remove(index);
        Injector.getReader().writeEntry("log.csv",logEntries);
    }

    public void deleteLogEntry(Log l){
        int index = logEntries.indexOf((Entry)l);
        deleteLogEntry(index);
    }

    public void startingConfigurationInit(String date, double calories, double weight){
        String[] dateSplit = date.split("-");
        this.year = Integer.parseInt(dateSplit[0]);
        this.month = Integer.parseInt(dateSplit[1]);
        this.day = Integer.parseInt(dateSplit[2]);

        this.calories = calories;
        this.weight = weight;
    }

    public double getCaloriesConsumed(){
        ArrayList<Recipe> foodIntake = new ArrayList<>();
        ArrayList<Double> helpings = new ArrayList<>();

        for(Entry log: logEntries){
            if(log.getType().equals("f")){
                Recipe r = Injector.getRecipeController().getRecipeByName(log.getName());
                foodIntake.add(r);
                helpings.add((Double)(log.getData()[5]));
            }
        }

        double calories = 0;
        for(int i = 0; i< foodIntake.size(); i++){
            calories += foodIntake.get(i).getTotalCalories() * helpings.get(i);
        }

        return calories;
    }

    public void initDay(){
        ArrayList<Log> groupedByDate = getLogsOndDay(year,month,day);

        boolean weight = false;
        boolean calories = false;

        for(Log l: groupedByDate){
            if(l.getType().equals("c")) calories = true;
            if(l.getType().equals("w")) weight = true;
        }

        if(weight && calories) return;

        Log l = new Log(String.format("%s,w,%.1f",getDate(),this.weight));
        addLogEntry(l);

        l = new Log(String.format("%s,c,%.1f",getDate(),this.calories));
        addLogEntry(l);
    }



    public double getCaloriesExpended(){
        ArrayList<Exercise> exercisesDone = new ArrayList<>();
        ArrayList<Double> duration = new ArrayList<>();

        for(Entry log: logEntries){
            if(log.getType().equals("e")){
                Exercise e = Injector.getExerciseController().getExerciseByName(log.getName());
                exercisesDone.add(e);
                duration.add((Double)(log.getData()[5]));
            }
        }

        //trebas provjerit kako ove proklete kalorije se trose ovisno o ovom kurcu
        double calories = 0;
        for(int i = 0; i< exercisesDone.size(); i++){
            calories += (Double)(exercisesDone.get(i).getData()[0]) * duration.get(i);
        }

        return calories;
    }

    public double getSingularIntakeCal(String name){
        return Injector.getRecipeController().getTotalsByName(name,1);
    }


    public double getSingularExpenditureCal(String name){
        Exercise e =  Injector.getExerciseController().getExerciseByName(name);
        return (Double)e.getData()[0];
    }

    public double getNetCalories(){
        return this.getCaloriesConsumed() - this.getCaloriesExpended();
    }

    public void modifyDefaults(double newCalorie, double newWeight){
        Log calorieLog = new Log(String.format("%d,%d,%d,c,%.1f",year,month,day,newCalorie));
        Log weightLog = new Log(String.format("%d,%d,%d,w,%.1f",year,month,day,newWeight));

        Log[] oldLogs = getSettings(year,month,day);

        logEntries.set(logEntries.indexOf(oldLogs[0]),calorieLog);
        logEntries.set(logEntries.indexOf(oldLogs[1]),weightLog);

        Injector.getReader().writeEntry("log.csv",logEntries);
    }

    private Log[] getSettings(int year, int month, int day){
        Log[] logs = new Log[2];
        for(Entry e: logEntries){
            Log l = (Log)e;

            if(l.getYear() == year && l.getMonth() == month && l.getDay() == day){
                if(l.getType().equals("c")) logs[0] = l;
                else if(l.getType().equals("w")) logs[1] = l;
            }
        }

        return logs;
    }

    public ArrayList<Log> getFoodsOnDay(int year, int month, int day){
        ArrayList<Log> foods = new ArrayList<>();

        for(Entry e: logEntries){
            Log l = (Log)e;

            if(l.getYear() == year && l.getMonth() == month && l.getDay() == day && l.getType().equals("f")){
                foods.add(l);
            }
        }

        return foods;
    }

    public ArrayList<Log> getExercisesOnDay(int year, int month, int day){
        ArrayList<Log> foods = new ArrayList<>();

        for(Entry e: logEntries){
            Log l = (Log)e;

            if(l.getYear() == year && l.getMonth() == month && l.getDay() == day && l.getType().equals("e")){
                foods.add(l);
            }
        }

        return foods;
    }

    private ArrayList<Log> getLogsOndDay(int year,int month, int day){
        ArrayList<Log> logs = new ArrayList<>();

        for(Entry e: logEntries){
            Log l = (Log)e;

            if(l.getYear() == year && l.getMonth() == month && l.getDay() == day ){
                logs.add(l);
            }
        }

        return logs;
    }



    /**
     * 2 - fat
     * 3 - carb
     * 4 - proteins
     * @param selector
     * @return
     */
    public double getTotals(int selector){
        ArrayList<Log> entriesThatINEED = getFoodsOnDay(year,month,day);

        double total = 0;
        for(Log l: entriesThatINEED){
            double retVal = Injector.getRecipeController().getTotalsByName(l.getName(),selector);
            total += retVal;
        }

        return total;
    }

    public ArrayList<String> getLogDates(){
        ArrayList<String> dates = new ArrayList<>();

        for(Entry e: logEntries){
            Log l = (Log)e;

            String date = l.getYear()+"-"+l.getMonth()+"-"+l.getDay();
            if(!dates.contains(date)) dates.add(date);
        }

        return dates;
    }

}
