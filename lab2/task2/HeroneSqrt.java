package lab2.task2;

import java.util.Scanner;

public class HeroneSqrt {

    public static double sqrt(double a, double x0) {
        return (1 / 2.0 * (x0 + a / x0));
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите значение a: ");
        double valueA = in.nextDouble();

        double error = 0.000001;
        double prevValue = valueA;
        double currValue = sqrt(valueA, prevValue); 
        double diff = Math.abs(currValue - prevValue);

        if (valueA > 0) {
            while (diff >= 2 * error && diff * diff >= 2 * error) {
                prevValue = currValue;
                currValue = sqrt(valueA, prevValue);
                diff = Math.abs(currValue - prevValue);
            }
        } else {
            System.out.println("Введите значение больше 0!");

        }
        
        System.out.println("Значение квадратного корня = " + currValue);
    }
}
