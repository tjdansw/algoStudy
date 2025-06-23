package dfs;

import java.io.*;
import java.util.*;

public class Baek_16724 {
    static int n, m, result = 0;
    static int[][] map;
    static boolean[][] visited, finished;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        finished = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'U') map[i][j] = 0;
                else if (c == 'R') map[i][j] = 1;
                else if (c == 'D') map[i][j] = 2;
                else if (c == 'L') map[i][j] = 3;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        int dir = map[x][y];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (!visited[nx][ny]) {
            dfs(nx, ny);
        } else if (!finished[nx][ny]) {
            result++;
        }

        finished[x][y] = true;
    }
}

/**
 * Union-Find 사용 풀이
 * 
 * 
 * import java.io.*;
 * import java.util.*;
 *
 * public class Main {
 *     static int n, m, result = 0;
 *     static int[] parent;
 *     static int[] dx = {-1, 0, 1, 0};
 *     static int[] dy = {0, 1, 0, -1};
 *
 *     static int getIndex(int x, int y) {
 *         return x * m + y;
 *     }
 *
 *     public static void main(String[] args) throws IOException {
 *         System.setIn(new FileInputStream("src/input.txt"));
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *
 *         n = Integer.parseInt(st.nextToken());
 *         m = Integer.parseInt(st.nextToken());
 *         parent = new int[n * m];
 *         int[][] map = new int[n][m];
 *
 *         for (int i = 0; i < n * m; i++) parent[i] = i;
 *
 *         for (int i = 0; i < n; i++) {
 *             String line = br.readLine();
 *             for (int j = 0; j < m; j++) {
 *                 char c = line.charAt(j);
 *                 if (c == 'U') map[i][j] = 0;
 *                 else if (c == 'R') map[i][j] = 1;
 *                 else if (c == 'D') map[i][j] = 2;
 *                 else if (c == 'L') map[i][j] = 3;
 *             }
 *         }
 *
 *         for (int x = 0; x < n; x++) {
 *             for (int y = 0; y < m; y++) {
 *                 int nx = x + dx[map[x][y]];
 *                 int ny = y + dy[map[x][y]];
 *                 int now = getIndex(x, y);
 *                 int next = getIndex(nx, ny);
 *                 union(now, next);
 *             }
 *         }
 *
 *         Set<Integer> set = new HashSet<>();
 *         for (int i = 0; i < n * m; i++) {
 *             set.add(find(i));
 *         }
 *
 *         System.out.println(set.size());
 *     }
 *
 *     static int find(int x) {
 *         if (parent[x] == x) return x;
 *         return parent[x] = find(parent[x]);
 *     }
 *
 *     static void union(int x, int y) {
 *         int px = find(x);
 *         int py = find(y);
 *         if (px != py) {
 *             parent[px] = py;
 *         }
 *     }
 * }
 */
