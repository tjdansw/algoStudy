package dynamic_programming;

import java.util.*;
import java.io.*;

// 30460
public class Baek_30460 {
    static int n, total = 0;
    static int[] nums, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
             nums[i] = Integer.parseInt(st.nextToken());
             total += nums[i];
        }

        for (int i = 0; i < n; i++) {
            int press = 0;
            for (int j = 0; j < 3; j++) {
                if(i+j==n) break;
                press += nums[i+j];
            }
            press = Math.max(press, 0);
            dp[i] = Math.max((i>0?dp[i-1]:0), (i<3?0:dp[i-3])+press);
        }
        System.out.println(total + dp[n-1]);
        System.out.println(Arrays.toString(dp));
    }
}
