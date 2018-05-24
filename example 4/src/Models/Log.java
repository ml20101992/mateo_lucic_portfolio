package Models;

public class Log implements Entry{
    private String type;
    private String name = "";
    private double value = 0.0;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
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

    private int year,month,day;

    public Log(String s){
        String[] split = s.split(",");

        year = Integer.parseInt(split[0]);
        month = Integer.parseInt(split[1]);
        day = Integer.parseInt(split[2]);
        type = split[3];

        if(type.equals("f") || type.equals("e")){
            this.name = split[4];
            this.value = Double.parseDouble(split[5]);
        }
        else{
            value = Double.parseDouble(split[4]);
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
        Object[] o = {year,month,day,type,name,value};

        return o;
    }

    @Override
    public String toFileFormat() {
        String retVal =  String.format("%d,%d,%d,%s,",year,month,day,type);
        if (type.equals("e")||type.equals("f")) retVal+=name+",";

        retVal+=String.format("%.1f",value);

        return retVal;
    }

}
