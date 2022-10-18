package lab5.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterVolume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> inputArray = stringToIntArray(input.nextLine());
        int maxVolume = 0;

        for (int i = 0; i < inputArray.size(); i++) {
            for (int j = 1; j < inputArray.size(); j++) {
                int volume = (j-i) * Math.min(inputArray.get(i), inputArray.get(j));
                if (volume > maxVolume) {
                    maxVolume = volume;
                }
            }
        }

        System.out.println(maxVolume);
    }
    public static List<Integer> stringToIntArray(String line) {
        String[] stringArray = line.split(",");

        List<Integer> intArray = new ArrayList<Integer>();

        for (int i = 0; i < stringArray.length; i++) {
            intArray.add(Integer.valueOf(stringArray[i]));
        }

        return intArray;
    }
}
