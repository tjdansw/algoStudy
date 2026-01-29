package dynamic_programming;

import java.io.*;

// 1823
public class Baek_1823 {
    static int n;
    static long[] costs;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new long[n+1];
        dp = new long[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            costs[i] = Long.parseLong(br.readLine());
            dp[i][i] = costs[i]*n;
        }

        for (int len = 2; len <= n; len++) {
            int k = n-len+1;
            for (int l = 1; l+len-1 <= n; l++) {
                int r = l+len-1;

                long flagLeft = dp[l+1][r] + costs[l]*k;
                long flagRight = dp[l][r-1] + costs[r]*k;
                dp[l][r] = Math.max(flagLeft, flagRight);
            }
        }
        System.out.println(dp[1][n]);
    }
}
