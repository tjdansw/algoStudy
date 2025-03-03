package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_2579 {
    static BufferedReader br;

    static int n;
    static int[] stairs,dp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stairs = new int[n+3];
        dp = new int[n+3];
        for (int i = 3; i < n+3; i++) stairs[i] = Integer.parseInt(br.readLine());

        for(int i=3; i<n+3; i++){
            dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
        }

        System.out.println(dp[n+2]);
    }
}
