package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 希尔排序
 * Created by guin_guo on 2017/2/25.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a进行希尔排序，步长为上一次的1/2.
     * @param a
     */
    public static void shellSort(int[] a) {
        for (int tk = a.length / 2; tk > 0; tk /= 2) {
            shellInsert(a, tk);
//            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 以步长为tk对数组a进行插入排序
     * @param a
     * @param tk
     */
    private static void shellInsert(int[] a, int tk) {
        int tmp = 0, j = 0;
        for (int i = tk; i < a.length; i++) {
            if (a[i] < a[i - tk]) {
                tmp = a[i];
                for (j = i - tk; j >= 0 && tmp < a[j]; j-=tk) {
                    a[j + tk] = a[j];
                }
                a[j + tk] = tmp;
            }
        }
    }
}
