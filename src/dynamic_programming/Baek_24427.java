package dynamic_programming;

import java.util.*;
import java.io.*;

// 24427
public class Baek_24427 {
    static int n, p;
    static int[][] map;
    static int[][][] dp;
    static boolean[][] checkCoordinates;
    static final int[] DX = {1, 0};
    static final int[] DY = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        checkCoordinates = new boolean[n+1][n+1];
        dp = new int[2][n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[1][i][j] = -1;
            }
        }
        p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkCoordinates[x][y] = true;
        }
        dp[0][1][1] = map[1][1];
        if(checkCoordinates[1][1]){
            dp[1][1][1] = map[1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==1&&j==1) continue;
                for (int k = 0; k < 2; k++) {
                    int pX = i - DX[k];
                    int pY = j - DY[k];
                    if(!isBound(pX, pY)) continue;
                    if(checkCoordinates[i][j]){
                        dp[1][i][j] = Math.max(dp[1][i][j], dp[0][pX][pY]+map[i][j]);
                        dp[1][i][j] = Math.max(dp[1][i][j], dp[1][pX][pY]+map[i][j]);
                        continue;
                    }
                    dp[0][i][j] = Math.max(dp[0][i][j], dp[0][pX][pY]+map[i][j]);
                    if(dp[1][pX][pY]!=-1){
                        dp[1][i][j] = Math.max(dp[1][i][j], dp[1][pX][pY]+map[i][j]);
                    }
                }
            }
        }
        System.out.println(dp[1][n][n]);
    }

    static boolean isBound(int x, int y){
        return 0<x&&x<=n&&0<y&&y<=n;
    }
}
