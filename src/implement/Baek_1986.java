package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1986 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, c;
    static int[][] map;
    static int[] qDx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] qDy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] kDx = {-2, -2, -1, 1, 2, 2, 1, -1,};
    static int[] kDy = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1986.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for (int t = 1; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            for (int i = 0; i < c; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = t;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) checkQueen(i, j);
                if (map[i][j] == 2) checkKnight(i, j);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void checkKnight(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int row = x + kDx[i];
            int col = y + kDy[i];
            if (isBound(row, col)&&map[row][col]<=0) {
                map[row][col] = -1;
            }
        }
    }

    private static void checkQueen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int row = x + qDx[i];
            int col = y + qDy[i];
            while (true) {
                if (isBound(row, col) && map[row][col] <= 0) {
                    map[row][col] = -1;
                    row += qDx[i];
                    col += qDy[i];
                } else {
                    break;
                }
            }
        }
    }

    static boolean isBound(int x, int y) {
        return !(x < 1 || x > n || y < 1 || y > m);
    }
}
