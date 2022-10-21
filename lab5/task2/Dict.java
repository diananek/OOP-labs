package lab5.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dict {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int wordCount = input.nextInt();input.nextLine();
        HashMap<String, List<String>> initDict = new HashMap<>();

        for (int i = 0; i < wordCount; i++) {
            String inputLine = input.nextLine();
            String[] arr = inputLine.split(" - ");
            initDict.put(arr[0], Arrays.asList(arr[1].split(", ")));
        }

        SortedMap<String, List<String>> resultDict = createDict(initDict);

        System.out.println(resultDict.size());
        for (Map.Entry<String, List<String>> entry : resultDict.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
            
        }
    }
    static SortedMap<String, List<String>> createDict(Map<String, List<String>> initDict) {
        SortedMap<String, List<String>> resultDict = new TreeMap<String, List<String>> ();
        for (Map.Entry<String, List<String>> entry : initDict.entrySet()) {
            List<String> latinWords = (List<String>) entry.getValue();
            for (int i = 0; i < latinWords.size(); i++) {
                if (!resultDict.containsKey(latinWords.get(i))) {
                    List<String> words = new ArrayList<String>();
                    words.add((String)entry.getKey());
                    resultDict.put((String)latinWords.get(i), words);
                } else {
                    List<String> words = resultDict.get(latinWords.get(i));
                    words.add((String)entry.getKey());
                    resultDict.put((String)latinWords.get(i), words);
                }
            }
        }
        return resultDict;
    }
}
