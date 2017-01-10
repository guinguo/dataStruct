package top.guinguo.algorithm;

/**
 * get sqrt by binary alg
 */
public class BinarySqrt {
    /**
     * print sqrt(2) = 1.4142135381698608
     */
    public static void main(String[] args) {
        System.out.println(getSqrt(7848516,1e-9));
        System.out.println(sqr(7848516));
    }

    /**
     * get sqrt(number) within precision
     * @param n
     * @param precision
     * @return
     */
    public static double getSqrt(double n, double precision) {
        double low = 0,high = n;
        double ave = (low + high) / 2;
        double doa;
        while ((doa = ave * ave) != n && Math.abs(doa - n) > precision) {
            if (doa > n) high = ave;
            else low = ave;
            ave = (low + high) / 2;
        }
        return ave;
    }

    /**
     * other good design
     * @param n
     * @return
     */
    public static double sqr(double n) {
        double k=1.0;
        while(Math.abs(k*k-n)>1e-9) {
            k=(k+n/k)/2;
        }
        return k;
    }

}
