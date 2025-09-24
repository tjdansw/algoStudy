package bfs;

import java.util.*;
import java.io.*;

// 1600
public class Baek_1600 {
    static int k, m, n;
    static int[][] map;
    static int[][][] visisted;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hDx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] hDy = {-1, 1, 2, 2, 1, -1, -2, -2};

    static class State{
        int horesMoveCnt;
        int moveCnt;
        int x, y;

        public State(int horesMoveCnt, int moveCnt, int x, int y) {
            this.horesMoveCnt = horesMoveCnt;
            this.moveCnt = moveCnt;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputData(br);
        if(n==1&&m==1&&map[0][0]==0){
            System.out.println(0);
            return;
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(k, 0, 0, 0));
        visisted[0][0][0] = 0;
        visisted[0][0][1] = k;
        while (!q.isEmpty()){
            State cur = q.poll();
            if(cur.horesMoveCnt>0){
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hDx[i];
                    int ny = cur.y + hDy[i];
                    if(isBound(nx, ny)&&map[nx][ny]==0&&(visisted[nx][ny][1]<cur.horesMoveCnt-1||visisted[nx][ny][0]>cur.moveCnt+1)){
                        if(nx==n-1&&ny==m-1){
                            System.out.println(cur.moveCnt+1);
                            return;
                        }
                        visisted[nx][ny][0] = Math.min(cur.moveCnt+1, visisted[nx][ny][0]);
                        if(visisted[nx][ny][1]<cur.horesMoveCnt-1){
                            visisted[nx][ny][1] = cur.horesMoveCnt-1;
                        }
                        q.add(new State(cur.horesMoveCnt-1, cur.moveCnt+1, nx, ny));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isBound(nx, ny)&&map[nx][ny]==0&&(visisted[nx][ny][1]<cur.horesMoveCnt||visisted[nx][ny][0]>cur.moveCnt+1)){
                    if(nx==n-1&&ny==m-1){
                        System.out.println(cur.moveCnt+1);
                        return;
                    }
                    visisted[nx][ny][0] = Math.min(cur.moveCnt+1, visisted[nx][ny][0]);
                    if(visisted[nx][ny][1]<cur.horesMoveCnt){
                        visisted[nx][ny][1] = cur.horesMoveCnt;
                    }
                    q.add(new State(cur.horesMoveCnt, cur.moveCnt+1, nx, ny));
                }
            }
        }
        System.out.println(-1);
    }

    static void inputData(BufferedReader br) throws IOException {
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visisted = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visisted[i][j][0] = 40_001;
            }
        }
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
}
