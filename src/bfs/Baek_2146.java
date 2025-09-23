package bfs;

import java.util.*;
import java.io.*;

// 2146
public class Baek_2146 {
    static int n, min = 201;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]!=1) continue;
                map[i][j] = idx;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(isBound(nx, ny)&&map[nx][ny]==1){
                            map[nx][ny] = idx;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                idx++;
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]||map[i][j]==0||(!isOutskirts(i, j))) {
                    visited[i][j] = true;
                    continue;
                }
                visited[i][j] = true;
                checkMinLen(i, j);
            }
        }

        System.out.println(min);
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }

    static boolean isOutskirts(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isBound(nx, ny)&&map[nx][ny]==0){
                return true;
            }
        }
        return false;
    }

    static void checkMinLen(int x, int y){
        int lenIdx = map[x][y];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{x, y, 0});
        boolean[][] isChecked = new boolean[n][n];
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(isBound(nx, ny)&&!isChecked[nx][ny]&&(map[nx][ny]==0||map[nx][ny]>lenIdx)){
                    if(map[nx][ny]>lenIdx){
                        min = Math.min(min, cur[2]);
                        return;
                    }
                    isChecked[nx][ny] = true;
                    pq.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
    }
}
