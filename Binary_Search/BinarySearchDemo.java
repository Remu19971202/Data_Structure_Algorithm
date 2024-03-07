package Binary_Search;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int result = binarySearch.binarySearch_ALTER_II(a, target);
        if (result == -1) {
            System.out.println("目标值 " + target + " 不存在于数组中");
        } else {
            System.out.println("目标值 " + target + " 在数组中的索引位置为 " + result);
        }
        int i = Arrays.binarySearch(a,target);
        System.out.println(i);
    }
}
