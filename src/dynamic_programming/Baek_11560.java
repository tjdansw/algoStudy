package dynamic_programming;

import java.util.*;
import java.io.*;

// 11560
public class Baek_11560 {
    static long[][] dp = new long[21][211];

    static{
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int k = 2;k<21;k++){
            int prev = (k*(k-1))/2;
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= prev; j++) {
                    dp[k][j+i] += dp[k-1][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(dp[k][n]).append('\n');
        }

        System.out.println(sb);
    }
}
