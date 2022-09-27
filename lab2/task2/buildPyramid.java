package lab2.task2;

import java.util.Scanner;

public class buildPyramid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите высоту пирамиды:");
        int pyramidHeight = in.nextInt(); 
        String line = "#";

        System.out.println("Pyramid height: " + pyramidHeight);
        for(int i = 1; i <= pyramidHeight; i++) {
            for(int j = pyramidHeight - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println(line + "  " + line);
            line += "#";
        }
    }
}
