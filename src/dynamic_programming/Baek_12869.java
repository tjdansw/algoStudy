package dynamic_programming;

import java.util.*;
import java.io.*;

// 12869
public class Baek_12869 {
    static final int[][] DAMAGE = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static int n;
    static int[][][] dp = new int[61][61][61];
    static int[] healths = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            healths[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0;
        System.out.println(solve(healths[0], healths[1], healths[2]));
    }

    static int solve(int a, int b, int c){
        if(dp[a][b][c]!=-1) return dp[a][b][c];
        int min = 100;
        for (int i = 0; i < 6; i++) {
            int x = Math.max(0, a-DAMAGE[i][0]);
            int y = Math.max(0, b-DAMAGE[i][1]);
            int z = Math.max(0, c-DAMAGE[i][2]);
            int value = 1 + solve(x, y, z);
            min = Math.min(min, value);
        }
        dp[a][b][c] = min;
        return dp[a][b][c];
    }
}
