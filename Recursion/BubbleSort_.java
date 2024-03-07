package Recursion;

import java.util.Arrays;

public class BubbleSort_ {

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 2, 8};
        f(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    //递归实现冒泡排序
    public static void BubbleSort_recursion(int[] a){
        f_01(a, a.length - 1);
    }
    //j代表未排序右边界
    private static void f(int[] a, int j){
        if (j==0){
            return;
        }
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        f(a, j - 1);
    }
    //改进冒泡,设置新的变量x,等于每次交换后的i,每一轮的最后一次交换后,x左边为未排序，
    //右边为已排序，减少递归循环的次数。
    private static void f_01(int[] a, int j){
        if (j==0){
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                x = i;
            }
        }
        f_01(a, x - 1); //直接从x的位置开始下次冒泡排序
    }

}
