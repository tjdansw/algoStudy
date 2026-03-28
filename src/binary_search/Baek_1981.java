package binary_search;

import java.util.*;
import java.io.*;

// 1981
public class Baek_1981 {
    static int n;
    static int[][] map;
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 200;
        for (int min = 0; min <= Math.min(map[1][1], map[n][n]); min++) {
            if (!canGo(min, 200)) continue;
            int l = min;
            int r = 200;

            while (l<=r) {
                int mid = (l+r)/2;

                if (canGo(min, mid)) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }

            answer = Math.min(answer, l - min);
        }

        System.out.println(answer);
    }

    static boolean canGo(int min, int max) {
        if (map[1][1]>max||map[n][n]>max) return false;

        boolean[][] visited = new boolean[n+1][n+1];
        Queue<int[]> q = new LinkedList<>();

        visited[1][1] = true;
        q.add(new int[]{1, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n && y == n) return true;
            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (!isBound(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] < min || map[nx][ny] > max) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return false;
    }

    static boolean isBound(int x, int y){
        return x>0&&x<=n&&y>0&&y<=n;
    }
}
