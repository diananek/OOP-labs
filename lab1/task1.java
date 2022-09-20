import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(System.in, "cp866");
            String userName = in.nextLine();
            System.out.printf("Привет, %s!", userName);
        }
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}