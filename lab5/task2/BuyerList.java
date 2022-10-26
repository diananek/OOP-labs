package lab5.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BuyerList {
    public static void main(String[] args) {
        SortedMap<String, SortedMap<String, Integer>> outputMap = new TreeMap<>();

        try {
            File file = new File("lab5/task2/data.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line = buffReader.readLine();
            while (line != null) {
                changeMap(line, outputMap);
                line = buffReader.readLine();
            }
            buffReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printMap(outputMap);
    }
    static void printMap(SortedMap<String, SortedMap<String, Integer>> outputMap) {
        ArrayList<String> keys = new ArrayList<String>(outputMap.keySet());

        for (int i = 0; i < outputMap.size(); i++) {
            System.out.println(keys.get(i) + ":");
            outputMap.get(keys.get(i)).forEach((key, value) -> System.out.println((key + " - " + value)));
        }
    }

    static void changeMap (String inputLine, SortedMap<String, SortedMap<String, Integer>> outputMap) {
        String[] splitedString = inputLine.split(" ");
        SortedMap<String, Integer> insertedMap;
        if(outputMap.containsKey(splitedString[0])){
            insertedMap = outputMap.get(splitedString[0]);

            if(insertedMap.containsKey(splitedString[1])){
                int quantityOfGoods = insertedMap.get(splitedString[1]);
                insertedMap.put(splitedString[1], quantityOfGoods + Integer.parseInt(splitedString[2]));
            } else {
                insertedMap.put(splitedString[1], Integer.parseInt(splitedString[2]));
            }
        } else {
            insertedMap = new TreeMap<>();
            insertedMap.put(splitedString[1], Integer.parseInt(splitedString[2]));
            outputMap.put(splitedString[0], insertedMap);
        }
    }

}
