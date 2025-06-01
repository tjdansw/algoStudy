package dynamic_programming;

import java.io.*;

public class Baek_17626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50_001];
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i;j++){
                min = Math.min(min,dp[i-j*j]+1);
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
