package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 二分查找版的插入排序
 * Created by guin_guo on 2017/2/24.
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        binarySort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a进行插入排序
     * 使用二分查找进行定位插入位置
     * @param a
     */
    public static void binarySort(int[] a) {
        int low,high,tmp,mid;
        for (int i = 1; i < a.length;i++) {
            tmp = a[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (a[mid] > tmp) high = mid - 1;
                else low = mid + 1;
            }
            for (int j = i-1;j>=high+1;j--) {
                a[j + 1] = a[j];
            }
            a[high + 1] = tmp;
        }
    }
}
