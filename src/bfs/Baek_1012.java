package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1012 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int T, n, m, k, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1012.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            cnt = 0;
            solve();
        }

        System.out.println(sb);
    }


    static void solve(){
        Queue<int[]> q;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1&&!visited[i][j]) {
                    cnt++;
                    visited[i][j] = true;
                    q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    while(!q.isEmpty()) {
                        int[] current = q.poll();
                        for(int idx = 0; idx < 4; idx++) {
                            int row = current[0] + dx[idx];
                            int col = current[1] + dy[idx];
                            if(isBound(row, col)&&!visited[row][col]&&map[row][col]==1) {
                                visited[row][col] = true;
                                q.add(new int[] {row, col});
                            }
                        }
                    }
                }
            }
        }
        sb.append(cnt).append('\n');
    }

    static boolean isBound(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }
}
