package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1520 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, cnt=0;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;
        dp[n-1][m-1] = solve(n-1,m-1);

        System.out.println(dp[n-1][m-1]);
    }

    static long solve(int x, int y) {
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int row = x + dx[i];
            int col = y + dy[i];
            if (isBound(row, col)&&map[x][y]<map[row][col]) {
                dp[x][y] += solve(row,col);
            }
        }
        return dp[x][y];
    }

    static boolean isBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
