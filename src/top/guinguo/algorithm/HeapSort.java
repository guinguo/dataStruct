package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 堆排序
 * Created by guin_guo on 2017/3/1.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组a进行堆排序
     * @param a
     */
    public static void heapSort(int[] a) {
        //循环建立初始堆
        for (int i = a.length/2;i>=0;i--) {
            heapAdjust(a, i, a.length-1);
        }
        int tmp = 0;
        //进行n-1次循环，完成排序
        for (int i = a.length-1;i>0;i--) {
            //最后一个元素和第一个元素交换
            tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;

            //筛选第0节点，得到i-1个节点的堆
            heapAdjust(a, 0, i);
        }
    }

    /**
     * 调整a的parent到length成为一个大顶堆
     * @param a
     * @param parent
     * @param length
     */
    private static void heapAdjust(int[] a, int parent, int length) {
        int tmp = a[parent]; //保存当前父节点的值
        //child = parent * 2 + 1先获得左孩子
        for (int child = parent * 2 + 1; child < length; child = child * 2 + 1) {
            //如果有右孩子，并且右孩子的值大于左孩子，则选取右孩子
            if (child + 1 < length && a[child] < a[child + 1]) child++;

            //如果父节点的只已经大于孩子节点的值，则直接结束
            if (tmp >= a[child]) break;

            //把孩子节点的值赋给父节点
            a[parent] = a[child];

            //更新父节点
            parent = child;
            //child = child * 2 + 1，选取孩子节点的的左孩子继续向下筛选
        }
        a[parent] = tmp;
    }
}
