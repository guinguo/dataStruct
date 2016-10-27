package top.guinguo.algorithm;

import java.util.Arrays;
import java.util.Collection;

/**
 * get next[] for KMP index
 */
public class NextOfKMP {
    /**
     * String[] a b a a b c a c
     * next[]   0 1 1 2 2 3 1 2
     * next is begin at index of 1
     * @param args
     */
    public static void main(String[] args) {
        String ss = "a,b,a,a,b,c,a,c";
        String[] s = ss.split(",");
        System.out.println(Arrays.toString(s));
        int[] next = getNext(s);
        System.out.println(Arrays.toString(next));
    }

    public static int[] getNext(String[] s) {
        int[] next = new int[s.length+1];
        int j = 0, i = 1;
        next[0] = 0;
        int length = s.length;
        while (i < length) {
            if (j == 0 || s[i - 1].equals(s[j - 1])) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
