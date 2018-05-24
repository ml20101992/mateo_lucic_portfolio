package Controllers;

import Models.*;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    private BufferedReader in;
    private BufferedWriter out;

    final String foods = "foods.csv";
    final String exercise = "exercises.csv";
    final String log = "log.csv";

    public ArrayList<String> readData(String type){
        String filename = "";

        switch (type){
            case "exercise":{
                filename = exercise;
            }break;

            case "log":{
                filename = log;
            }break;
            default:{
                filename = foods;
            }break;
        }

        initReader(filename);

        if(type.equals("log")||type.equals("exercise")){
            return readData();
        }
        else{
            if(type.equals("basic")) return readData(true);
            else return readData(false);
        }
    }

    private ArrayList<String> readData(){
        ArrayList<String> entries = new ArrayList<>();

        String line = "";
        try {
            while ((line = in.readLine())!=null) {
                entries.add(line);
            }
        }catch (IOException e){
            System.out.println("Error reading line");
            e.printStackTrace();
        }

        return entries;
    }

    private ArrayList<String> readData(boolean basic){
        ArrayList<String> data = readData();
        String regex = "f";

        if(basic){
            regex = "b";
        }


        ArrayList<String> returns = new ArrayList<>();

        for(String entry: data){
            if(entry.substring(0,1).equals(regex)){
                returns.add(entry);
            }
        }

        return returns;
    }

    public ArrayList<String> readStringData(String filename){
        initReader(filename);

        return readData();
    }

    public ArrayList<Entry> readFood(){
        ArrayList<String> results = readData("basic");

        ArrayList<Entry> returns = new ArrayList<>();

        for(String r: results){
            returns.add(new BasicFood(r));
        }

        return returns;
    }

    public ArrayList<Entry> readRecipes(){
        ArrayList<String> results = readData("recipe");

        ArrayList<Entry> returns = new ArrayList<>();

        for(String r: results){
            returns.add(new Recipe(r));
        }

        return returns;
    }

    public ArrayList<Entry> readExercises(){
        ArrayList<String> results = readData("exercise");

        ArrayList<Entry> returns = new ArrayList<>();

        for(String r: results){
            returns.add(new Exercise(r));
        }

        return returns;
    }

    public ArrayList<Entry> readLog(){
        ArrayList<String> strings = readStringData("log.csv");

        ArrayList<Entry> logs = new ArrayList<>();
        for(String s: strings){
            Log l = new Log(s);
            logs.add(l);
        }

        return logs;
    }


    public void writeEntry(String filename,ArrayList<Entry> entries){
        initWriter(filename);

        for(Entry e: entries){
            try {
                out.write(String.format("%s%n",e.toFileFormat()));
                out.flush();
            } catch (IOException e1) {
                System.out.println("error writing data");
                e1.printStackTrace();
            }
        }
    }

    public void writeStrings(String filename,ArrayList<String> entries){
        initWriter(filename);

        for(String s: entries){
            try {
                out.write(String.format("%s%n",s));
                out.flush();
            } catch (IOException e1) {
                System.out.println("error writing data");
                e1.printStackTrace();
            }
        }
    }


    public void modifyEntry(String filename,Entry oldEntry,Entry newEntry){
        initReader(filename);
        ArrayList<String> data = readData();

        if(data.contains(oldEntry.toFileFormat())){
            int index = data.indexOf(oldEntry.toFileFormat());
            data.set(index,newEntry.toFileFormat());
        }

//        for(String s: data){
//            if(s.equals(oldEntry.toFileFormat())){
//                int index = data.indexOf(oldEntry.toFileFormat())
//            }
//        }

        initWriter(filename);
        writeStrings(filename,data);
    }



    public void deleteEntry(String filename, Entry entry){
        initReader(filename);
        ArrayList<String> data = readData();

        if(data.contains(entry.toFileFormat())){
            data.remove(entry.toFileFormat());
        }

        initWriter(filename);
        writeStrings(filename,data);
    }


    private void initReader(String readSource){
        String filename = readSource;

        try {
            in = new BufferedReader(new FileReader(filename));

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    private void initWriter(String writeSource){
        try{
            out = new BufferedWriter(new FileWriter(writeSource,false));
        }catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

    }
}
