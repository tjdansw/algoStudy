package dynamic_programming;

import java.util.*;
import java.io.*;

// 1749
public class Baek_1749 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int up = 0; up < n; up++) {
            int[] temp = new int[m];

            for (int down = up; down < n; down++) {
                for (int c = 0; c < m; c++) {
                    temp[c] += map[down][c];
                }

                int cur = temp[0];
                int subMax = temp[0];
                for (int i = 1; i < m; i++) {
                    cur = Math.max(temp[i], cur+temp[i]);
                    subMax = Math.max(subMax, cur);
                }
                max = Math.max(max, subMax);
            }
        }

        System.out.println(max);
    }
}