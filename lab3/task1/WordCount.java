package lab3.task1;

import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Что ищем: ");
        String word = input.nextLine();
        System.out.println("Где ищем: ");
        int count = 0;
        while (true) {
            String line = input.nextLine();
            if (line.isBlank()) {
                break;
            } else {
                count += searchWord(word, line);
            }
        }
        System.out.println(count);
    }
    public static int searchWord(String word, String line) {
        int count = 0;
        while (line.contains(word)){
            if (word.length() > 1) {
                line = line.substring(line.indexOf(word) + word.length() - 1);
            } else {
                line = line.substring(line.indexOf(word) + word.length());
            }
            count ++;
        }
        return count;
    }
}
