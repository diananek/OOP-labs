package lab5.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        List inputArray = Arrays.asList(inputLine.split(" "));
        HashSet resultArray = new HashSet<>(inputArray);
        System.out.println(resultArray);
    }
}
