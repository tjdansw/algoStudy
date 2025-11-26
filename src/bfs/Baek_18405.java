package bfs;

import java.util.*;
import java.io.*;

// 18405
public class Baek_18405 {
    static int n, k, s, x, y;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class VirusInfor{
        int x, y, time;

        public VirusInfor(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        PriorityQueue<VirusInfor> pq = new PriorityQueue<>((a, b)->{
            if(a.time==b.time) return Integer.compare(map[a.x][a.y], map[b.x][b.y]);
            return Integer.compare(a.time, b.time);
        });
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0){
                    pq.add(new VirusInfor(i, j, 0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        while (!pq.isEmpty()){
            VirusInfor cur = pq.poll();
            if(cur.time>=s) continue;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isBound(nx,ny)&&map[nx][ny]==0){
                    map[nx][ny] = map[cur.x][cur.y];
                    pq.add(new VirusInfor(nx, ny, cur.time+1));
                }
            }
        }
        System.out.println(map[x][y]);
    }

    static boolean isBound(int x, int y){
        return x>0&&x<=n&&y>0&&y<=n;
    }
}
