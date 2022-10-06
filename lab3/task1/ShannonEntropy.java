package lab3.task1;

import java.util.Arrays;
import java.util.Scanner;

public class ShannonEntropy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        System.out.printf("%.2f%n", calculateEntropy(text));
        
    }
    
    public static double calculateEntropy(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);

        double[] countChars = new double[Character.MAX_VALUE];

        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            countChars[charAt]++;
        }

        Arrays.sort(countChars);
        int countsSum = getSum(countChars);

        for (int i = 0; i < countChars.length; i++) {
            if (countChars[i] > 0) {
                countChars[i] /= countsSum;
            } 
        }

        double entropy = 0.0;
        for (int i = 0; i < countChars.length; i++) {
            if (countChars[i] > 0) {
                entropy -= countChars[i] * (Math.log(countChars[i]) / Math.log(2));
            } 
        }

        return entropy;
    }

    public static int getSum(double[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {
                sum += list[i];
            }
        }
        return sum;
    }


}
