package dynamic_programming;

import java.io.*;

// 15990
public class Baek_15990 {
    static final long MOD = 1_000_000_009;
    static final int SIZE = 100_000;
    static long[][] dp = new long[SIZE + 1][4];

    static {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= SIZE; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            answer.append(ans).append('\n');
        }
        System.out.println(answer);
    }
}
