package top.guinguo.algorithm;

import java.util.Arrays;

/**
 * 有趣的排序-->睡眠排序
 * Created by guin_guo on 2017/3/2.
 */
public class SleepSort {
    public static void main(String[] args) {
        int[] a = {5, 56, 320, 87, 600, 95, 167, 3, 229, 23, 450};
        System.out.println(Arrays.toString(a));
        SleepSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 原理：构造n个线程，他们和这n个数一一对应，
     * 初始化后，它们开始睡眠，等到对应的数那么多个时间单位后各自醒来，
     * 然后输出它对应的数。这样最小的数对应的线程最早醒来，最早被输出。
     * 等所有的线程都醒来，排序就结束了。
     * @param nums
     */
    public static void sort(int[] nums) {
        Sleeper.idx = 0;
        Sleeper.output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            new Sleeper(nums[i]).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Sleeper.output[i];
        }
    }
}
