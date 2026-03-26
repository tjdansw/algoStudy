package dynamic_programming;

import java.io.*;

// 15988
public class Baek_15988 {
    static final long MOD = 1_000_000_009;
    static final int SIZE = 1_000_001;
    static long[] dp = new long[1_000_001];

    static {
        dp[0] = 1;
        for (int i = 1; i < SIZE; i++) {
            for (int k = 1; k <= 3&&i-k>=0; k++) {
                dp[i] = (dp[i]+dp[i-k])%MOD;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            answer.append(dp[n]).append('\n');
        }
        System.out.println(answer);
    }
}
