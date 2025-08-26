package dynamic_programming;

import java.util.*;
import java.io.*;

// 2225
public class Baek_2225 {
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k+1][n+1];
        dp[0][0] = 1;

        for(int i=1; i <= k; i++){
            for(int j=0; j <= n; j++){
                for(int m=0; m <= j; m++){
                    dp[i][j] += dp[i-1][j-m];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
