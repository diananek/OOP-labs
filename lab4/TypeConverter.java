package lab4;
import java.util.Scanner;

public class TypeConverter {
    public static void main(String args[])
    {   
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сообщение:"); 
        String message = input.next(); 
        System.out.println("Введите тип:"); 
        String type = input.next();

        try {
            System.out.println(convertMessage(message, type));
        } catch (NumberFormatException e) {
            System.out.println("Данное сообщение нельзя привести к типу "
             + type);
            System.out.println(e.getMessage());
        }
    }

    public static Object convertMessage(String message, String type) {
        switch (type.toLowerCase()) {
            case "char":
                return message.charAt(0);
            case "byte":
                return Byte.parseByte(message);
            case "short":
                return Short.parseShort(message);
            case "int", "integer":
                return Integer.parseInt(message);
            case "long":
                return Long.parseLong(message);
            case "float":
                return Float.parseFloat(message);
            case "double":
                return Double.parseDouble(message);
            case "boolean":
                return Boolean.parseBoolean(message);
            default:
                return message;
        }
    }
}
