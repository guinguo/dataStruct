package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * Created by guin_guo on 2017/2/28.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a进行选择排序
     * 在每一趟n-i+1(i=1,2,3...n-1)个记录中选取最小的记录，和第i个元素交换。
     * @param a
     */
    public static void selectSort(int[] a) {
        int tmp = 0, min = 0;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i+1;j<a.length;j++) {
                if (a[j] < a[min]) min = j;
            }
            if (i != min) {
                tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}
