package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2151
public class Baek_2151 {
    static int N;
    static char[][] map;
    static int[][][] dp;
    static int[][] doors = new int[2][2];
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    static class State{
        int x, y, d;

        public State(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        dp = new int[N][N][4];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j],1_000_000);
                map[i][j] = line.charAt(j);
                if (map[i][j] == '#') {
                    doors[idx][0] = i;
                    doors[idx++][1] = j;
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        int sx = doors[0][0];
        int sy = doors[0][1];
        for (int i = 0; i < 4; i++) {
            q.add(new State(sx, sy, i));
            dp[sx][sy][i] = 0;
        }

        while (!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;;
            int d = cur.d;

            int nx = x + DX[d];
            int ny = y + DY[d];

            if(!isBound(nx, ny)||map[nx][ny]=='*') continue;

            if((map[nx][ny]=='.'||map[nx][ny]=='#')&&dp[nx][ny][d]>dp[x][y][d]){
                dp[nx][ny][d]=dp[x][y][d];
                q.add(new State(nx, ny, d));
                continue;
            }

            if(map[nx][ny]=='!'){
                if(dp[nx][ny][d]>dp[x][y][d]){
                    dp[nx][ny][d]=dp[x][y][d];
                    q.add(new State(nx, ny, d));
                }
                if(dp[nx][ny][(d+1)%4]>dp[x][y][d]+1){
                    dp[nx][ny][(d+1)%4]=dp[x][y][d]+1;
                    q.add(new State(nx, ny, (d+1)%4));
                }
                if(dp[nx][ny][(d+3)%4]>dp[x][y][d]+1){
                    dp[nx][ny][(d+3)%4]=dp[x][y][d]+1;
                    q.add(new State(nx, ny, (d+3)%4));
                }
            }
        }

        int ex = doors[1][0];
        int ey = doors[1][1];
        int answer = 1_000_000;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[ex][ey][i]);
        }
        System.out.println(answer);
    }

    static boolean isBound(int x, int y){
        return 0<=x&&x<N&&0<=y&&y<N;
    }
}
