package lab2.task2;

import java.util.Scanner;

public class HeroneSqrt {

    public static double sqrt(int userNumber) {
        double result = userNumber;
        int i = 0;
        while ((result * result > userNumber) && (i < 100)) {
            result = ((result + userNumber / result) / 2);
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int number = in.nextInt();
        double result = 0;

        if (number > 0) {
            result = sqrt(number);
        } else {
            System.out.println("Введите значение больше 0!");

        }
        
        System.out.println(result);
    }
}
