package dynamic_programming;

import java.util.*;
import java.io.*;

// 1757
public class Baek_1757 {
    static int n, m;
    static int[] distanceRun;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distanceRun = new int[n];
        dp = new int[n][m+1];

        for(int i = 0; i<n; i++){
            distanceRun[i] = Integer.parseInt(br.readLine());
            for(int j = 0;j<=m;j++){
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;
        dp[0][1] = distanceRun[0];
        for(int i = 1;i<n;i++){
            // 계속 뛰는 경우
            for(int j = 1;j<=m;j++){
                if(dp[i-1][j-1]==-1) continue;
                dp[i][j] = dp[i-1][j-1] + distanceRun[i];
            }
            // 쉬는 경우
            dp[i][0] = dp[i-1][0];
            for(int j = 0;j<=m&&i-j>=0;j++){
                dp[i][0] = Math.max(dp[i][0], dp[i-j][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n-1][0]);
    }
}
