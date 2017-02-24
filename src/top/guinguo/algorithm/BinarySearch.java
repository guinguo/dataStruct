package top.guinguo.algorithm;

/**
 * 二分查找
 * Created by guin_guo on 2017/2/23.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {3, 5, 23, 56, 87, 95, 167, 229, 320, 450, 600};
        int index = binarySearch(a, 5);
        System.out.println(index);
    }

    /**
     * 在有序列表查找value的位置，不存在返回-1
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch(int[] a, int value) {
        int low = 0, high = a.length;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (a[mid] == value) return mid;
            else if (a[mid]>value) high = mid - 1;
            else low = mid + 1;
            mid = (low + high) / 2;
        }
        return -1;
    }
}
