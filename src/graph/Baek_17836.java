package graph;

import java.util.*;
import java.io.*;

// 17836
public class Baek_17836 {
    static int n, m, t, swordX, swordY;
    static int[][] map, dp, dpHasSword;
    static final int MAX = 1_000_000;
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, -1, 0, 1};

    static class State{
        int x, y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        dpHasSword = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = MAX;
                dpHasSword[i][j] = MAX;
                if(map[i][j]==2){
                    swordX = i;
                    swordY = j;
                }
            }
        }

        dp[1][1] = 0;
        Queue<State> q = new LinkedList<>();
        q.add(new State(1, 1));
        while (!q.isEmpty()){
            State state = q.poll();
            int x = state.x;
            int y = state.y;

            int time = dp[x][y] +1;
            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(isBound(nx, ny)&&map[nx][ny]!=1&&time<dp[nx][ny]&&time<=t){
                    dp[nx][ny] = time;
                    q.add(new State(nx, ny));
                }
            }
        }

        dpHasSword[swordX][swordY] = 0;
        q.add(new State(swordX, swordY));
        while (!q.isEmpty()){
            State state = q.poll();
            int x = state.x;
            int y = state.y;

            int time = dpHasSword[x][y] +1;
            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(isBound(nx, ny)&&time<dpHasSword[nx][ny]&&time<=t){
                    dpHasSword[nx][ny] = time;
                    q.add(new State(nx, ny));
                }
            }
        }

        int answer = MAX;
        if(dp[n][m]!=MAX){
            answer = dp[n][m];
        }
        answer = Math.min(answer, dp[swordX][swordY]+dpHasSword[n][m]);

        System.out.println(answer>t?"Fail":answer);
    }

    static boolean isBound(int x, int y){
        return x>0&&x<=n&&y>0&&y<=m;
    }
}
