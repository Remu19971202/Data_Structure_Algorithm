package Binary_Search;

//给定一个内含n个元素的有序数组A，满足：A0≤A1≤A2≤……≤A(n-1),一个待查值target
//1，设置i = 0，j = n-1;
//2.如果i＞j,结束查找,没找到;
//3.设置m = floor(i+j)/2,m为中间索引,floor是向下取整;
//4.如果target<Am,设置j = m-1,跳到第2步;
//5.如果Am<target,设置i = m+1,跳到第2步;
//6.如果Am = target,结束查找，找到了.
public class BinarySearch {
    public static int binarySearch_BASIC(int[] a, int target) {
        int i = 0, j = a.length - 1; //设置初始指针值
        while (i <= j) {
            int m = (i + j) >>> 1; //右移替换(i + j) / 2
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    //j变为边界，指向的一定不是查找目标
    public static int binarySearch_ALTER(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    //1.左闭右开的区间,i指向的可能是目标,而j指向的不是目标;
    //2.不在循环内找出,等范围只剩i时(即i、j之间没有元素,j-i=1),退出循环,在循环外比较a[i]与target;
    //3.循环内的平均比较次数减少了;
    //4.时间复杂度log(n).
    public static int binarySearch_ALTER_II(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) { //范围内待查找的元素个数
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
//        if (a[i] == target) {
//            return i;
//        } else {
//            return -1;
//        }
        return (a[i] == target) ? i : -1;
    }

    // 数组中有相同元素的情况
    public static int binarySearch_LeftMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        //加入候选者candidate记录查找的候选元素
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
                // i = m + 1; //RightMost
            }
        }
        return candidate;
    }

    public static int binarySearch_LeftMost_ver2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) { //小于和等于后的操作是相同的
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i; //返回≥target的最靠左索引
    }

    public static int binarySearch_RightMost_ver2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1; //返回≤target的最靠右索引
    }

    //递归实现二分查找
    public static int binarySearch_recursion(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }
    private static int f(int[] a, int target, int i, int j) {
        int mid = (i + j) >>> 1;
        if (target < a[mid]) {
            return f(a, target, i, mid - 1);
        } else if (a[mid] < target) {
            return f(a, target, mid + 1, j);
        } else {
            return mid;
        }
    }
}

