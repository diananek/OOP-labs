package lab2.task1;

import java.util.Scanner;

public class PrintDays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер месяца и год: ");
        int monthNumber = input.nextInt();
        int year = input.nextInt();
        int daysNumber = 0;
        if (year > 0 && monthNumber > 0) {
            if (monthNumber == 2) {
                if(year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            daysNumber = 29;
                        } else {
                            daysNumber = 28;
                        }
                    } else {
                        daysNumber = 29;
                    }
                } else {
                    daysNumber = 28;
                }
            } else {
                daysNumber = 28 + (monthNumber + monthNumber / 8) % 2 
                + 2 % monthNumber + 1 / monthNumber * 2;
            }
            System.out.println(daysNumber);
        } else {
            System.out.println("Месяц и год должны быть больше нуля!");
        }
        
    }
}
