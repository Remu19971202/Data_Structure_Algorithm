package Recursion;

import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<Integer>();
    static LinkedList<Integer> b = new LinkedList<Integer>();
    static LinkedList<Integer> c = new LinkedList<Integer>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c) {
        if(n==0){
            return;
        }
        move(n-1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n-1, b, a, c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3, a, b, c);
    }

    private static void print() {
        System.out.println("--------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
