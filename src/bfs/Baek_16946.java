package bfs;

import java.util.*;
import java.io.*;

// 16946
public class Baek_16946 {
    static int n, m;
    static int[][] map;
    static int[][] group;
    static Map<Integer, Integer> groupSize = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int groupId = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    bfs(i, j, groupId++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    Set<Integer> nearGroups = new HashSet<>();
                    int sum = 1;
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];
                        if (isInBound(x, y) && group[x][y] != 0) {
                            int gId = group[x][y];
                            if (!nearGroups.contains(gId)) {
                                sum += groupSize.get(gId);
                                nearGroups.add(gId);
                            }
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y, int groupId) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        group[x][y] = groupId;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (isInBound(nx, ny) && map[nx][ny] == 0 && group[nx][ny] == 0) {
                    group[nx][ny] = groupId;
                    size++;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        groupSize.put(groupId, size);
    }

    static boolean isInBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
