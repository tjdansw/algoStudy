package graph;

import java.util.*;
import java.io.*;

// 1937
public class Baek_1937 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] == -1) dfs(i,j);
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }

    static int dfs(int x, int y){
        if(dp[x][y] == -1){
            int cnt = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isBound(nx, ny)&&map[x][y]<map[nx][ny]){
                    cnt = Math.max(dfs(nx,ny)+1, cnt);
                }
            }
            dp[x][y] = cnt;
        }
        return dp[x][y];
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
}
