package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * Created by guin_guo on 2017/2/23.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 使用插入法排序数组a，使其递增
     * @param a
     */
    public static void insertSort(int[] a) {
        int j = 0, tmp = 0;
        for (int i = 1;i<a.length;i++) {
            if (a[i] < a[i - 1]) {
                tmp = a[i];
                for (j = i-1;j>=0&&tmp<a[j];j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = tmp;
            }
        }
    }
}
