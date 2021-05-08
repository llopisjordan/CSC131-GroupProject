package com.example.simplerestapis;

//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class readCSV{


    public static List<Movies> all(){
        String filmYear;
        String ceremonyYear;
        String ceremony;
        String category;
        String Name;
        String film;
        String winner;

        ArrayList<Movies> arr = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/jthic/spring/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_awardtest2.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (!arrOfStr[5].equals(""))
                {
                    filmYear = arrOfStr[0];
                    ceremonyYear = arrOfStr[1];
                    ceremony = arrOfStr[2];
                    category = arrOfStr[3];
                    Name = arrOfStr[4];
                    film = arrOfStr[5];
                    winner = arrOfStr[6];

                    category = category.replaceAll("\\s+", "_").toUpperCase();

                    Movies object =(new Movies(filmYear, Name, ceremony, film));

                    if (!arr.contains(object)){
                        arr.add(object);
                    }

                    arr.get(arr.indexOf(object)).addAward(new Award(category, Name, Boolean.parseBoolean(winner)));

                }

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static ArrayList<String> get_Category()
    {
        String category;
        ArrayList<String> arr = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/jthic/spring/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_awardtest2.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (!arrOfStr[5].equals(" "))
                {
                    category = arrOfStr[3];
                    category = category.replaceAll("\\s+", "_").toUpperCase();
                    arr.add(category);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(arr);
        return arr;
    }

    public static ArrayList<String> get_Titles()
    {
        String title;
        ArrayList<String> arr = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/jthic/spring/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_awardtest2.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (!arrOfStr[5].equals(" "))
                {
                    title = arrOfStr[5];
                    arr.add(title);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(arr);
        return arr;
    }

}



