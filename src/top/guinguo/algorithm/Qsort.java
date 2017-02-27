package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 * Created by guin_guo on 2017/2/27.
 */
public class Qsort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        qsort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a从 low 到 high 部分进行快速排序
     * @param a
     * @param low
     * @param high
     */
    public static void qsort(int[] a, int low, int high) {
        if (low < high) {
            int pivo = Partition(a, low, high);
            qsort(a, low, pivo - 1);
            qsort(a, pivo + 1, high);
        }
    }

    /**
     * 交换数组a中字表 low 到 high 的记录，使枢轴记录到位，并返回其所在位置，
     * 此时在它之前（后）的记录均不大（小）与它
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int Partition(int[] a, int low, int high) {
        int tmp = a[low];
        while (low < high) {
            while (low < high && a[high] >= tmp) --high;
            a[low] = a[high];
            while (low < high && a[low] <= tmp) ++low;
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }
}
