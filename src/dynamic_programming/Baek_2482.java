package dynamic_programming;

import java.io.*;

// 2482
public class Baek_2482 {
    static int n, k;
    static final long MOD = 1_000_000_003;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        dp = new long[n+1][n+1];

        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = i;
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (dp[i-1][j]+dp[i-2][j-1])%MOD;
            }
        }
        long answer = k==1?n:(dp[n-1][k]+dp[n-3][k-1])%MOD;
        System.out.println(answer);
    }
}
