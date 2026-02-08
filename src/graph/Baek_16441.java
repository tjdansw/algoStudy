package graph;

import java.util.*;
import java.io.*;

// 16441
public class Baek_16441 {
    static int n, m;
    static char[][] map;
    static boolean[][] notSafe;
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        notSafe = new boolean[n][m];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]!='W'|| notSafe[i][j]) continue;
                checkMap(i, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]=='W'||map[i][j]=='.'){
                    sb.append(notSafe[i][j]?map[i][j]:'P');
                    continue;
                }
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void checkMap(int x, int y){
        notSafe[x][y] = true;
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int nx = cur[0];
            int ny = cur[1];
            for (int k = 0; k < 4;) {
                nx += DX[k];
                ny += DY[k];
                if(visited[nx][ny]) continue;
                if(map[nx][ny]=='.'){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    notSafe[nx][ny] = true;
                    nx = cur[0];
                    ny = cur[1];
                    k++;
                    continue;
                }else if(map[nx][ny]=='+'){
                    visited[nx][ny] = true;
                    notSafe[nx][ny] = true;
                    if(map[nx+DX[k]][ny+DY[k]]=='#'){
                        q.add(new int[]{nx, ny});
                        nx = cur[0];
                        ny = cur[1];
                        k++;
                    }
                    continue;
                }
                nx = cur[0];
                ny = cur[1];
                k++;
            }
        }
    }
}
