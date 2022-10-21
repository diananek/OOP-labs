package lab5.task3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ValidityCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(isValid(input.next()));

    }
    public static boolean isValid(String bracketsInput) {
        Deque<Character> bracketsDeque = new LinkedList<>();       
        for (int i = 0; i < bracketsInput.length(); i++) {
            if ((bracketsInput.charAt(i) == '(') || (bracketsInput.charAt(i) == '{') || (bracketsInput.charAt(i) == '[')) {
                bracketsDeque.offer(bracketsInput.charAt(i));
            }
            else {
                if (bracketsDeque.isEmpty()) return false;
                if ((bracketsDeque.peekLast() != '(') && (bracketsInput.charAt(i) == ')')) return false;
                if ((bracketsDeque.peekLast() != '{') && (bracketsInput.charAt(i) == '}')) return false;
                if ((bracketsDeque.peekLast() != '[') && (bracketsInput.charAt(i) == ']')) return false;
                bracketsDeque.removeLast();
            }
        }
        return bracketsDeque.isEmpty();
    }

}
