package dynamic_programming;

import java.util.*;
import java.io.*;

// 14722
public class Baek_14722 {
    static int n;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    int prevDrinkCnt = 0;
                    if(i>0) prevDrinkCnt = Math.max(prevDrinkCnt, dp[i-1][j][k]);
                    if(j>0) prevDrinkCnt = Math.max(prevDrinkCnt, dp[i][j-1][k]);

                    if(prevDrinkCnt>0){
                        int nextType = (k+1)%3;
                        if(map[i][j]==nextType){
                            dp[i][j][nextType] = Math.max(dp[i][j][nextType], prevDrinkCnt+1);
                        }else{
                            dp[i][j][k] = Math.max(dp[i][j][k], prevDrinkCnt);
                        }
                    }else if(k==2&&map[i][j]==0){
                        dp[i][j][0] = Math.max(dp[i][j][0], 1);
                    }
                }
            }
        }

        int answer = Math.max(Math.max(dp[n-1][n-1][0],dp[n-1][n-1][1]),dp[n-1][n-1][2]);
        System.out.println(answer);
    }
}
