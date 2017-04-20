package top.guinguo.algorithm;

/**
 * @描述: 动态规划之 0-1背包
 * @作者: guin_guo
 * @日期: 2017-04-20 19:30
 * @版本: v1.0
 */
public class Knapsack {
    private static int N = 6; // 物品数量+1
    private static int M = 21; // 背包容量+1
    private static int[][] B = new int[N][M]; // 背包容量+1 默认值为0
    private static int[] W = {0, 2, 3, 4, 5, 9}; // 每件商品的重量
    private static int[] V = {0, 3, 4, 5, 8, 10}; // 每件商品的价值
    private static int[] X = new int[N]; // 最优值

    public static void main(String[] args) {
        knapsack();
        traceback();
        System.out.println("最大价值：" + B[N - 1][M - 1]);
        System.out.print("最优解：[");
        for (int i = 1; i < N - 1; i++) {
            System.out.print(X[i] + ", ");
        }
        System.out.print(X[N - 1] + "]");
    }

    /**
     * 背包算法
     * B[k][c] =
     * {
     *  1. B[k-1][c]; <==第k件商品太重
     *  2. MAX{ B[k-1][c-W[k]]+V[k] , B[k-1][c] } <==否则
     * }
     */
    public static void knapsack() {
        int k; // 第k件商品
        int c; // 背包剩余容量
        for (k=1;k<N;k++) {
            for (c=1;c<M;c++) {
                if (W[k] > c) {
                    B[k][c] = B[k - 1][c];
                } else {
                    int value1 = B[k - 1][c - W[k]] + V[k];//拿第k件的价值
                    int value2 = B[k - 1][c];//不拿第k件的价值
                    B[k][c] = value1 > value2 ? value1 : value2;
                }
            }
        }
    }

    /**
     * 对应最优解算法
     * 如果B[5][c] == B[4][c],则X5 = 0;否则X5 = 1;
     * 当X5 == 0时，继续构造最优解。
     * 当X5 == 1时，由B[4][c - w5] 继续构造最优解。以此类推，可以构造出相应的最优解（x1,x2,x3...xn）.
     */
    public static void traceback() {
        int c = M - 1;
        for (int i = N - 1; i > 1; i--) {
            if (B[i][c] == B[i - 1][c]) {
                X[i] = 0;
            } else {
                X[i] = 1;
                c -= W[i];
            }
        }
        X[1] = B[1][c] != 0 ? 1 : 0;
    }
}
