package dynamic_programming;

import java.util.*;
import java.io.*;

// 5557
public class Baek_5557 {
    static int n;
    static int[] nums;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        dp = new long[n+1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(i==1){
                dp[i][nums[i]] = 1;
                continue;
            }
            for (int j = 0; j < 21; j++) {
                if(dp[i-1][j] == 0) continue;
                int next = j + nums[i];
                if(next>=0&&next<21) {
                    dp[i][next] += dp[i-1][j];
                }
                next = j - nums[i];
                if(next>=0&&next<21) {
                    dp[i][next] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n-1][nums[n]]);
    }
}
