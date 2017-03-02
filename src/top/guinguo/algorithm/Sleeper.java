package top.guinguo.algorithm;

/**
 * 睡眠排序线程类
 * Created by guin_guo on 2017/3/2.
 */
class Sleeper extends Thread {
    public static int[] output;
    public static int idx;
    private int sleep_time;

    public Sleeper() {
    }

    public Sleeper(int sleep_time) {
        this.sleep_time = sleep_time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.sleep_time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output[idx++] = this.sleep_time;
    }
}