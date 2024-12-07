package bfs;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_31575 {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0, 0);

        System.out.println(Arrays.deepToString(visited));
        if (visited[M - 1][N - 1]) sb.append("YES");
        else sb.append("NO");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(int rowIdx, int colIdx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rowIdx, colIdx});
        visited[rowIdx][colIdx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            rowIdx = cur[0];
            colIdx = cur[1];

            for (int i = 0; i < 2; i++) {
                int nextRowIdx = rowIdx + dr[i];
                int nextColIdx = colIdx + dc[i];

                if (nextRowIdx < 0 || nextRowIdx >= M || nextColIdx < 0 || nextColIdx >= N) continue;
                if (map[nextRowIdx][nextColIdx] == 1 && !visited[nextRowIdx][nextColIdx]) {
                    visited[nextRowIdx][nextColIdx] = true;
                    q.offer(new int[]{nextRowIdx, nextColIdx});
                }
            }
        }
    }
}