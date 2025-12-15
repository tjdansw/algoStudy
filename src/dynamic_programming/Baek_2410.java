package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2410
public class Baek_2410 {
    static final long MOD = 1_000_000_000;
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        dp[0] = 1;
        int p = 1;
        while (p<=n){
            for (int i = p; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-p])%MOD;
            }
            p<<=1;

        }
        System.out.println(dp[n]);
    }
}
