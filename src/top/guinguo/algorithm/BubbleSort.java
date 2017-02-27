package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by guin_guo on 2017/2/27.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a进行冒泡排序
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int tmp = 0;
        for (int i = a.length;i>0;i--) {
            for (int j = 0; j<i-1;j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
