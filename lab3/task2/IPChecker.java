package lab3.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPChecker {
    public static void main(String [] args) {
        String ip = "2001:0db8:85a3:0000:0000:8a2d:0370:7334";
        String IP_PATTERN = "((^|:)([0-9a-fA-F]{0,4})){1,8}";
        System.out.println(validate(ip, IP_PATTERN));

    }

    public static boolean validate(String text, String ipPattern) {
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
