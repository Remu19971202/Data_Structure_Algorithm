package Recursion;

public class Factorial {

    public static void main(String[] args) {
        int V = Factorial.f(5);
        System.out.println(V);
    }

    public static int f(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * f(n - 1);
        }
    }
}
