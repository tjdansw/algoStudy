package dynamic_programming;

import java.util.*;
import java.io.*;

// 9084
public class Baek_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t= Integer.parseInt(br.readLine());
        int[] coins = new int[20];

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            dp[0] = 1;
            for(int i = 0;i<n;i++){
                for(int j = coins[i];j<=m;j++){
                    dp[j] += dp[j-coins[i]];
                }
            }
            sb.append(dp[m]).append('\n');
        }
        System.out.println(sb);
    }
}
