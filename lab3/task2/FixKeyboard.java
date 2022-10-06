package lab3.task2;

import java.util.Scanner;

public class FixKeyboard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in, "cp866");

        System.out.println("Введите слово: ");
        String word = input.nextLine();

        String result = word.replaceAll("(.)\\1{2,}", "$1");

        System.out.println(result);
    }

}
