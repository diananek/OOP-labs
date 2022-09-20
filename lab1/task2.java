public class task2 {
    public static void main(String[] args) {
        System.out.println (String.format("Max byte value = %d, min byte value = %d", Byte.MAX_VALUE, Byte.MIN_VALUE)); // 8-bit
        System.out.println (String.format("Max short value = %d, min short value = %d", Short.MAX_VALUE, Short.MIN_VALUE)); // 16-bit
        System.out.println (String.format("Max int value = %d, min int value = %d", Integer.MAX_VALUE, Integer.MIN_VALUE)); // 32-bit
        System.out.println (String.format("Max long value = %d, min long value = %d", Long.MAX_VALUE, Long.MIN_VALUE)); // 64-bit
        System.out.println (String.format("Max float value = %e, min float value = %e", Float.MAX_VALUE, Float.MIN_VALUE)); // 32-bit IEEE 754
        System.out.println (String.format("Max double value = %e, min double value = %e", Double.MAX_VALUE, Double.MIN_VALUE)); // 64-bit IEEE 754
    }
}
