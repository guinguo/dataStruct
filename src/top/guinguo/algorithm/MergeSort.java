package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * Created by guin_guo on 2017/3/3.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序函数，temp为临时数组。
     * @param a
     */
    public static void mergeSort(int[] a) {
        MSort(a, 0, a.length - 1);
    }

    /**
     * 归并排序的递归函数，
     * 通过递【归】非接一个长度为n的数组为n个数组，再合【并】这n个数组
     * @param a
     * @param first
     * @param last
     */
    public static void MSort(int[] a, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            MSort(a, first, mid);
            MSort(a, mid + 1, last);
            Merge(a, first, mid, last);
        }
    }

    /**
     * 将有两个有序数组a[first...mid] 和a[mid...last] 合并。temp为临时数组
     * @param a
     * @param first
     * @param mid
     * @param last
     */
    public static void Merge(int[] a, int first, int mid, int last) {
        int[] temp = new int[last - first + 1];
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= m)
            temp[k++] = a[i++];
        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0;i<k;i++) {
            a[first + i] = temp[i];
        }

    }

}
