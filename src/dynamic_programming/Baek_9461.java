package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_9461 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t,n;
    static long[] dp = new long[101];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        dp[6]=3;
        for(int i=7;i<101;i++){
            dp[i]= dp[i-1]+dp[i-5];
        }

        t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
}
