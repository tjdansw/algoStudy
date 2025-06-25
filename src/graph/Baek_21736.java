package graph;

import java.util.*;
import java.io.*;

// 21736
public class Baek_21736 {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        int x=0, y=0;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if(c=='I'){
                    x = i;
                    y = j;
                }else if(c=='P'){
                    map[i][j] = 1;
                }else if(c=='X'){
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];
            for(int i = 0; i < 4; i++) {
                int r = x+dx[i];
                int c = y+dy[i];
                if(isBound(r,c)&&!visited[r][c]){
                    visited[r][c] = true;
                    cnt+=map[r][c];
                    q.add(new int[]{r,c});
                }
            }
        }
        System.out.println(cnt==0?"TT":cnt);
    }

    private static boolean isBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
