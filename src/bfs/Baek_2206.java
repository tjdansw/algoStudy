package bfs;

import java.io.*;
import java.util.*;

public class Baek_2206 {
    static int n, m;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, breakWall;

        public Node(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2206.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j][0] = Integer.MAX_VALUE;
                visited[i][j][1] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int breakWall = current.breakWall;

            if (x == n - 1 && y == m - 1) {
                return visited[x][y][breakWall];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && visited[nx][ny][breakWall] == Integer.MAX_VALUE) {
                        visited[nx][ny][breakWall] = visited[x][y][breakWall] + 1;
                        queue.offer(new Node(nx, ny, breakWall));
                    }

                    if (map[nx][ny] == 1 && breakWall == 0 && visited[nx][ny][1] == Integer.MAX_VALUE) {
                        visited[nx][ny][1] = visited[x][y][breakWall] + 1;
                        queue.offer(new Node(nx, ny, 1));
                    }
                }
            }
        }
        return -1;
    }
}
