package dijkstra;

import java.util.*;
import java.io.*;

// 23563
public class Baek_23563 {
    static int h, w;
    static char[][] map;
    static int[][] arriveTimes;
    static int sx = 0, sy = 0, ex = 0, ey = 0;

    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        arriveTimes = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                arriveTimes[i][j] = 1_000_000;
                if(map[i][j]=='S'){
                    sx = i;
                    sy = j;
                }
                if(map[i][j]=='E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        arriveTimes[sx][sy] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(arriveTimes[a[0]][a[1]], arriveTimes[b[0]][b[1]]));
        pq.add(new int[]{sx, sy});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int time = arriveTimes[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(map[nx][ny] == '#') continue;

                if(!isNearWall(nx, ny)&&arriveTimes[nx][ny]>time+1){
                    arriveTimes[nx][ny] = time+1;
                    pq.add(new int[]{nx, ny});
                    continue;
                }
                if(isNearWall(nx, ny)){
                    if(isNearWall(x, y)&&arriveTimes[nx][ny] > time){
                        arriveTimes[nx][ny] = time;
                        pq.add(new int[]{nx, ny});
                    }else if(!isNearWall(x, y)&&arriveTimes[nx][ny] > time+1){
                        arriveTimes[nx][ny] = time+1;
                        pq.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(arriveTimes[ex][ey]);
    }

    static boolean isNearWall(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if(map[nx][ny]=='#') return true;
        }
        return  false;
    }

}
