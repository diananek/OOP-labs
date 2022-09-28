package lab2.task1;
import java.util.Scanner;

public class GameDecision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Сегодня воскресенье? 0 - нет, 1 - да");
        boolean isSunday = in.nextInt() == 1 ? true : false;
        if (isSunday) {
            System.out.println("Какая сегодня температура? 0 - жарко, 1 - тепло, 2 - холодно");
            int temperatureSelect = in.nextInt();
            if (temperatureSelect == 0 | temperatureSelect == 1) {
                System.out.println("Какие сегодня осадки? 0 - ясно, 1 - облачно,"
                + "2 - дождь, 3 - снег, 4 - град");
                int precipitationSelect = in.nextInt();
                if (precipitationSelect == 0 | precipitationSelect == 1) {
                    System.out.println("Есть ли ветер? 0 - нет, 1 - да");
                    boolean isWind = in.nextInt() == 1 ? true : false;
                    if (!isWind) {
                        System.out.println("Влажность? 0 - низкая, 1 - высокая");
                        boolean isWet = in.nextInt() == 1 ? true : false;
                        if (!isWet) {
                            System.out.println("Вы хотите играть в бадминтон!");
                            return;

                        } 
                    }
                }
            }
        }
        System.out.println("Вы не хотите играть в бадминтон");

    }
}
