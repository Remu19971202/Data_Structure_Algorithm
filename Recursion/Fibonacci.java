package Recursion;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    private static int f(int n, int[] cache) {
        if (cache[n] != -1){
            return cache[n];
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    //记忆法改进
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }
}
