package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_4485 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;

    static int tc = 1,n, total;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        while((n = Integer.parseInt(br.readLine())) != 0) {
            map = new int[n][n];
            dp = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = map[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return Integer.compare(dp[a[0]][a[1]], dp[b[0]][b[1]]);
            });
            pq.add(new int[]{0, 0});
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();

                if(cur[0]==n-1&&cur[1]==n-1) {
                    break;
                }

                for(int i = 0; i < 4; i++) {
                    int row = cur[0] + dx[i];
                    int col = cur[1] + dy[i];
                    if(isBound(row, col)&&dp[row][col] > dp[cur[0]][cur[1]]+map[row][col]) {
                        dp[row][col] = dp[cur[0]][cur[1]]+map[row][col];
                        pq.add(new int[]{row, col});
                    }
                }
            }
            sb.append("Problem ").append(tc++).append(": ").append(dp[n-1][n-1]).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {
        if(x==n-1&&y==n-1) return;
        for(int i = 0; i < 4; i++) {
            int row = x + dx[i];
            int col = y + dy[i];
            if(isBound(row, col)&&dp[row][col] > dp[x][y]+map[row][col]) {
                dp[row][col] = dp[x][y]+map[row][col];
                bfs(row, col);
            }
        }
    }

    public static boolean isBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
