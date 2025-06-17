package dynamic_programming;

import java.io.*;
import java.util.*;

// 11054
public class Baek_11054 {
    static int n;
    static int[] nums;
    static int[] ascDp, descDp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        ascDp = new int[n];
        descDp = new int[n];
        Arrays.fill(ascDp, 1);
        Arrays.fill(descDp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ascDp[i] = Math.max(ascDp[i], ascDp[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    descDp[i] = Math.max(descDp[i], descDp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, ascDp[i] + descDp[i] - 1);
        }

        System.out.println(max);
    }
}
