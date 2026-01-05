package dynamic_programming;

import java.io.*;

// 1955
public class Baek_1955 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;

        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= i / 2; a++) {
                dp[i] = Math.min(dp[i], dp[a] + dp[i - a]);
            }

            for (int d = 2; d * d <= i; d++) {
                if (i % d == 0) {
                    int e = i / d;
                    dp[i] = Math.min(dp[i], dp[d] + dp[e]);
                }
            }

            if (i <= 7) {
                int f = fact(i);
                if (f <= n) dp[f] = Math.min(dp[f], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }

    static int fact(int x) {
        int r = 1;
        for (int i = 2; i <= x; i++) r *= i;
        return r;
    }
}
