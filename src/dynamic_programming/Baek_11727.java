package dynamic_programming;

import java.io.*;

public class Baek_11727 {
    static final int MOD = 10_007;
    static int n;
    static int[] dp = new int[1010];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp[0] = 1;

        for(int i = 0; i <n; i++) {
            dp[i+1] = (dp[i+1]+dp[i])%MOD;
            dp[i+2] = (dp[i+2]+dp[i]*2)%MOD;
        }

        System.out.println(dp[n]);
    }
}
