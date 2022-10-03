package lab2.task3;

import java.util.Arrays;
import java.util.Scanner;

public class Median {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите набор чисел: ");
        String[] inputArray = input.nextLine().split(" ");

        double[] nums = new double[inputArray.length];
        int arrLenght = nums.length;

        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Double.valueOf(inputArray[i]);
        }

        Arrays.sort(nums);
        double median;
 
        if (arrLenght % 2 != 0) {
            median = nums[arrLenght / 2];
        } else {
            median = (nums[(arrLenght - 1) / 2] + nums[arrLenght / 2]) / 2.0;
        }   
        System.out.println(median);        
    }
}
