package lab2.task1;

import java.util.Scanner;

public class AgeOutput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите свой возраст: ");
        int age = input.nextInt();
        if (age > 0) {
            if ((age % 100 >= 10 && age % 100 <= 20) | (age % 10 > 4 && age % 10 < 10)) {
                System.out.printf("%d лет", age);
            } else if (age % 10 == 1) {
                System.out.printf("%d год", age);
            } else {
                System.out.printf("%d года", age);
            }
        } else {
            System.out.println("Введите значение больше нуля!");
        }
    }
}
