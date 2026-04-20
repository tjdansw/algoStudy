package dynamic_programming;

import java.util.*;
import java.io.*;

// 1744
public class Baek_1744 {
    static int n;
    static int[] nums, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        dp = new int[n+1];
        nums[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            dp[i] = Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]+nums[i]);
            if(i<n){
                dp[i+1] = Math.max(dp[i+1], dp[i-1]+(nums[i]*nums[i+1]));
            }
        }
        System.out.println(dp[n]);
    }
}
