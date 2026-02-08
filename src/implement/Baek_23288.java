package implement;

import java.util.*;
import java.io.*;

// 23288
public class Baek_23288 {
    static int n, m, k;
    static int[][] map, mapIdx;
    static HashMap<Integer, Integer> costByIdx = new HashMap<>();

    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    static final int TOP = 0, BOTTOM = 1, NORTH = 2, SOUTH = 3, EAST = 4, WEST = 5;

    static int[] dice = {1, 6, 2, 5, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        mapIdx = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mapIdx[i][j] != 0) continue;

                int flag = map[i][j];
                int cnt = 1;

                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                mapIdx[i][j] = idx;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + DX[d];
                        int ny = y + DY[d];
                        if (isBound(nx, ny) && map[nx][ny] == flag && mapIdx[nx][ny] == 0) {
                            mapIdx[nx][ny] = idx;
                            cnt++;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }

                costByIdx.put(idx, cnt);
                idx++;
            }
        }

        int totalScore = 0;
        int moveCnt = 0;
        int dir = 0;
        int x = 1, y = 1;

        while (moveCnt < k) {
            int nx = x + DX[dir];
            int ny = y + DY[dir];

            if (!isBound(nx, ny)) {
                dir = (dir + 2) % 4;
                continue;
            }

            moveCnt++;
            roll(dir);
            x = nx;
            y = ny;

            int compSize = costByIdx.get(mapIdx[x][y]);
            totalScore += map[x][y] * compSize;

            int A = dice[BOTTOM];
            int B = map[x][y];

            if (A > B) dir = (dir + 1) % 4;
            else if (A < B) dir = (dir + 3) % 4;
        }

        System.out.println(totalScore);
    }

    private static boolean isBound(int x, int y) {
        return 0 < x && x <= n && 0 < y && y <= m;
    }

    static void roll(int dir) {
        int t = dice[TOP];

        if (dir == 0) {
            dice[TOP] = dice[WEST];
            dice[WEST] = dice[BOTTOM];
            dice[BOTTOM] = dice[EAST];
            dice[EAST] = t;

        } else if (dir == 2) {
            dice[TOP] = dice[EAST];
            dice[EAST] = dice[BOTTOM];
            dice[BOTTOM] = dice[WEST];
            dice[WEST] = t;

        } else if (dir == 1) {
            dice[TOP] = dice[NORTH];
            dice[NORTH] = dice[BOTTOM];
            dice[BOTTOM] = dice[SOUTH];
            dice[SOUTH] = t;

        } else {
            dice[TOP] = dice[SOUTH];
            dice[SOUTH] = dice[BOTTOM];
            dice[BOTTOM] = dice[NORTH];
            dice[NORTH] = t;
        }
    }
}
