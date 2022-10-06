package lab3.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
    
public class EmailChecker {
    public static void main(String [] args) {
        String email = "Privalova1.diana@yandex.ru";
        String EMAIL_PATTERN = "^[A-Za-z0-9_.-]+@[A-Za-z0-9-]+\\.[A-Za-z0-9-.]+$";
        System.out.println(validate(email, EMAIL_PATTERN));

    }

    public static boolean validate(String email, String emailPattern) {
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
