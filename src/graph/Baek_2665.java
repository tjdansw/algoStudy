package graph;

import java.util.*;
import java.io.*;

// 2665
public class Baek_2665 {
    static int n;
    static int[][] map, visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j] = 3000;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0] = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int breakCnt = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isBound(nx, ny)) continue;

                if(map[nx][ny]==1&&visited[nx][ny]>breakCnt){
                    visited[nx][ny] = breakCnt;
                    q.add(new int[]{nx, ny, breakCnt});
                }else if(map[nx][ny]==0&&visited[nx][ny]>breakCnt+1){
                    visited[nx][ny] = breakCnt+1;
                    q.add(new int[]{nx, ny, breakCnt+1});
                }
            }
        }
        System.out.println(visited[n-1][n-1]);
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
}
