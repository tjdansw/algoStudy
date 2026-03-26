package dynamic_programming;

import java.io.*;
import java.util.*;

// 9764
public class Baek_9764 {
    static final int MOD = 100999;
    static int[][] dp;

    static int dfs(int sum, int first) {
        if (sum == first) return 1;
        if (dp[sum][first] != -1)
            return dp[sum][first];

        int remain = sum - first;
        int res = 0;
        for (int next = first + 1; next <= remain; next++) {
            res += dfs(remain, next);
            res %= MOD;
        }
        return dp[sum][first] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        dp = new int[max + 1][max + 1];
        for (int i = 0; i <= max; i++)
            Arrays.fill(dp[i], -1);

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            int ans = 0;

            for (int j = 1; j <= n; j++) {
                ans += dfs(n, j);
                ans %= MOD;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}