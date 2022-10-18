package lab5.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutateArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PermutateArray permArray = new PermutateArray();

        int[] inputArray = stringToIntArray(input.nextLine());

        List<List<Integer>> permute = permArray.perms(inputArray);
        
        printArray(permute);
    }

    public List perms(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permsHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permsHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (resultList.contains(arr[i])) {
                    continue;
                }
                resultList.add(arr[i]);
                permsHelper(list, resultList, arr);
                resultList.remove(resultList.size() - 1);
            }
        }
    }
    public static void printArray(List<List<Integer>> arr) {
        System.out.print("[");
        for (int i = 0; i < arr.size(); i++) {
            if (i != arr.size() - 1) {
                System.out.print(arr.get(i) + ", ");
            } else {
                System.out.print(arr.get(i));
            }
        }
        System.out.print("]");
    }
    public static int[] stringToIntArray(String line) {
        String[] stringArray = line.split(" ");

        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.valueOf(stringArray[i]);
        }

        return intArray;
    }
}
