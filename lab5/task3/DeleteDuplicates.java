package lab5.task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> inputArray = stringToIntArray(input.nextLine());
        HashSet<Integer> resultArray = new HashSet<Integer>(inputArray);
        System.out.println(resultArray);
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
