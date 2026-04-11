package bitoperator;

import java.io.*;

// 1562
public class Baek_1562 {
    static int n;
    static long[][][] dp;
    static final long MOD = 1_000_000_000;
    static final int FULL = (1<<10)-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10][1 << 10];

        for (int d = 1; d <= 9; d++) {
            dp[1][d][1 << d] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int d = 0; d <= 9; d++) {
                for (int mask = 0; mask < (1 << 10); mask++) {
                    int newMask = mask | (1 << d);
                    if (d > 0) {
                        dp[len][d][newMask] =
                                (dp[len][d][newMask] + dp[len - 1][d - 1][mask]) % MOD;
                    }
                    if (d < 9) {
                        dp[len][d][newMask] =
                                (dp[len][d][newMask] + dp[len - 1][d + 1][mask]) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        for (int d = 0; d <= 9; d++) {
            answer = (answer + dp[n][d][FULL]) % MOD;
        }

        System.out.println(answer);
    }
}
