package lab5.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SharesProfit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> inputArray = stringToIntArray(input.nextLine());

        System.out.println(maxProfit(inputArray));
    }

    public static int maxProfit(List<Integer> arr) {
        int maxPrice = Collections.max(arr.subList(1, arr.size()));
        int maxPriceIdx = arr.indexOf(maxPrice);

        int minPrice =  Collections.min(arr.subList(0, maxPriceIdx));
        int minPriceIdx = arr.indexOf(minPrice);

        if (maxPriceIdx > minPriceIdx && maxPrice > minPrice) {
            return maxPrice - minPrice;
        } else {
            return 0;
        }

    }

    public static List<Integer> stringToIntArray(String line) {
        String[] stringArray = line.split(" ");

        List<Integer> intArray = new ArrayList<Integer>();

        for (int i = 0; i < stringArray.length; i++) {
            intArray.add(Integer.valueOf(stringArray[i]));
        }

        return intArray;
    }
}
