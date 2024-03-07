package Recursion;

public class Sum_ {

    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static long sum(long n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
