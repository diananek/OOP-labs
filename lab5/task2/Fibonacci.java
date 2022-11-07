package lab5.task2;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        cache.put(0, 0L);
        cache.put(1, 1L);
        int num = 15;

        long timeFirst = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            long result = getFibonacci(num);
        }
        System.out.print("Классическая реализация: ");
        System.out.println(System.currentTimeMillis() - timeFirst + "(мс)");

        long timeSecond = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            long result = getCachedFibonacci(15);
        }
        System.out.print("Реализация с кэшированием: ");
        System.out.println(System.currentTimeMillis() - timeSecond + "(мс)");
    }
    
    private static final Map<Integer, Long> cache = new HashMap<Integer, Long>();

    public static long getFibonacci(int num) {
        if (num == 0) {
            return 0L;
        }
        if (num == 1) {
            return 1L;
        } else {
            return getFibonacci(num - 1) + getFibonacci(num - 2);
        }
    }

    public static Long getCachedFibonacci(int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        Long result = getCachedFibonacci(num - 1) + getCachedFibonacci(num - 2);
        cache.put(num, result);
        return getFibonacci(num - 1) + getFibonacci(num - 2);
        
    }
}