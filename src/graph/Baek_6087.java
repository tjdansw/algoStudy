package graph;

import java.util.*;
import java.io.*;

// 6087
public class Baek_6087 {
    static int W, H;
    static char[][] map;
    static int[][][] dist;
    static int[][] coordinates = new int[2][2];
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    static class State{
        int x, y, dir, changeCnt;

        public State(int x, int y, int dir, int changeCnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.changeCnt = changeCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        dist = new int[H][W][4];

        int idx = 0;
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                for (int d = 0; d < 4; d++)
                    dist[i][j][d] = 100_000;

                if(map[i][j]=='C'){
                    coordinates[idx][0] = i;
                    coordinates[idx++][1] = j;
                }
            }
        }

        Queue<State> q = new LinkedList<>();

        int sx = coordinates[0][0];
        int sy = coordinates[0][1];

        for(int d = 0; d < 4; d++){
            dist[sx][sy][d] = 0;
            q.add(new State(sx, sy, d, 0));
        }

        while (!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int prev = cur.dir;
            int change = cur.changeCnt;

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if(!isBound(nx, ny) || map[nx][ny]=='*') continue;

                int next = change + (prev==i?0:1);

                if(dist[nx][ny][i] > next){
                    dist[nx][ny][i] = next;
                    q.add(new State(nx, ny, i, next));
                }
            }
        }

        int tx = coordinates[1][0];
        int ty = coordinates[1][1];

        int answer = 100_000;
        for(int d = 0; d < 4; d++){
            answer = Math.min(answer, dist[tx][ty][d]);
        }

        System.out.println(answer);
    }

    static boolean isBound(int x, int y){
        return 0<=x && x<H && 0<=y && y<W;
    }
}
