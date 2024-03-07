package Recursion;

public class InsertionSort_ {

    //递归实现插入排序
    public static void InsertionSort_recursion(int[] a) {
        f(a, 1);
    }

    //low代表未排序区域的下边界
    private static void f(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int temp = a[low];
        int i = low - 1;//已排序区域的上边界

        while (i >= 0 && a[i] > temp) {
            a[i + 1] = a[i];
            i--;
        }
        if (i + 1 != low) {
            a[i + 1] = temp;
        }

        f(a, low + 1);
    }
}
