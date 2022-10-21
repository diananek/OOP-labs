package lab4;

public class ValueOutRangeException extends Exception {
    public String toString() {
        String msg = "Value is out of range";
        return msg;
    }
}
