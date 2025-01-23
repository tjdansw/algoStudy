package bellman_ford;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_16924 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_16924.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '*') {
                    int maxLen = getMaxLen(i, j);
                    if (maxLen > 0) {
                        visited[i][j] = true;
                        for (int len = 1; len <= maxLen; len++) {
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d] * len;
                                int ny = j + dy[d] * len;
                                visited[nx][ny] = true;
                            }
                        }
                        result.add(new int[]{i + 1, j + 1, maxLen});
                    }
                }
            }
        }

        if (!isValid()) {
            System.out.println(-1);
        } else {
            System.out.println(result.size());
            for (int[] cross : result) {
                sb.append(cross[0]).append(" ")
                        .append(cross[1]).append(" ")
                        .append(cross[2]).append("\n");
            }
            System.out.print(sb);
        }
    }

    static int getMaxLen(int x, int y) {
        int size = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * (size + 1);
                int ny = y + dy[i] * (size + 1);
                if (!isBound(nx, ny) || map[nx][ny] != '*') {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            size++;
        }
        return size;
    }

    static boolean isBound(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

    static boolean isValid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
