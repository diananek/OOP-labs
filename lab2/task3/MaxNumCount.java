package lab2.task3;
import java.util.Scanner;

public class MaxNumCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите набор чисел: ");
        String[] inputArray = input.nextLine().split(" ");

        int[] nums = new int[inputArray.length];
        int maxNum = nums[0];
        int count = 0;

        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.valueOf(inputArray[i]);
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxNum) {
                count++;
            }
        }

        System.out.println(count);

    }
}
