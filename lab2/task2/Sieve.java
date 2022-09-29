package lab2.task2;

import java.util.Scanner;

public class Sieve {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество чисел: ");
        int number = input.nextInt();

        int[] prime = new int[number + 1];
		for (int i = 2; i <= number; i++){
			prime[i] = i;	
		}

        for (int i = 2; i * i <= number; i++) {
            for (int j = i * i; j <= number; j += i) {
                prime[j] = 0;
            }
        }

        System.out.println("Простые числа:");

        for(int i = 2; i <= number; i ++) {
            if(prime[i] != 0) {
                System.out.print(prime[i] + " ");
            }
        }
    }
}
