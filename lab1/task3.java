import java.util.InputMismatchException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            double edge = in.nextDouble();
            double volume = ((15 + 5 * Math.sqrt(5.0)) / 12 * Math.pow(edge, 3));
            System.out.println(volume);
        }
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}