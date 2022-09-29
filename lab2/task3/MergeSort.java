package lab2.task3;

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int arrLenght = array.length;
        if (arrLenght < 2) {
            return;
        }
        int mid = arrLenght / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arrLenght - mid];
    
        for (int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }
        for (int i = mid; i < arrLenght; i++) {
            rightArr[i - mid] = array[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
    
        merge(array, leftArr, rightArr, mid, arrLenght - mid);
    }
    public static void merge(
  int[] array, int[] leftArr, int[] rightArr, int left, int right) {
 
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            }
            else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < left) {
            array[k++] = leftArr[i++];
        }
        while (j < right) {
            array[k++] = rightArr[j++];
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите набор чисел: ");
        String[] inputArray = input.nextLine().split(" ");

        int[] nums = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.valueOf(inputArray[i]);
        }
        mergeSort(nums);
        System.out.println("Результат сортировки:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
    }
}
