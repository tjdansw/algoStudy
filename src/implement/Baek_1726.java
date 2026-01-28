package implement;

import java.util.*;
import java.io.*;

// 1726
public class Baek_1726 {
    static int n, m;
    static int[][] map;
    static int[][][] dp;
    static State start, end;
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    static class State{
        int x, y, dir;

        public State(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new State(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, dir(Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        end = new State(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, dir(Integer.parseInt(st.nextToken())));
        dp[start.x][start.y][start.dir] = 0;
        Queue<State> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.dir;
            int moveLen = dp[x][y][d];
            for (int i = -1; i < 2; i++) {
                if(i==0) continue;
                int nd = (d+i+4)%4;
                if(dp[x][y][nd]>moveLen+1){
                    dp[x][y][nd] = moveLen+1;
                    q.add(new State(x, y, nd));
                }
            }
            for (int i = 1; i < 4; i++) {
                x += DX[d];
                y += DY[d];
                if(isBound(x, y)&&map[x][y]==0){
                    if(dp[x][y][d]>moveLen+1){
                        dp[x][y][d] = moveLen+1;
                        q.add(new State(x, y, d));
                    }
                    continue;
                }
                break;
            }
        }
        System.out.println(dp[end.x][end.y][end.dir]);
    }

    static int dir(int k){
        if(k==1) return 0;
        else if(k==3) return 1;
        else if(k==2) return 2;
        return 3;
    }

    static boolean isBound(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<m;
    }
}
