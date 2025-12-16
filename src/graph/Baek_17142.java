package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17142
public class Baek_17142 {
    static int n, m, virusCount = 0, min = 2_500;
    static int[][] map;
    static int[][] viruses = new int[10][2];
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    viruses[virusCount][0] = i;
                    viruses[virusCount++][1] = j;
                }
            }
        }
        selectViruses(new int[m], 0, 0);
        System.out.println(min==2_500?-1:min);
    }

    static void bfs(int[] virusIdxs) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        int emptyTotal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) emptyTotal++;
            }
        }

        if (emptyTotal == 0) {
            min = 0;
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        for (int idx : virusIdxs) {
            int x = viruses[idx][0];
            int y = viruses[idx][1];
            dist[x][y] = 0;
            q.add(new int[]{x, y});
        }

        int infectedEmpty = 0;
        int maxTime = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];
                if (!isBound(nx, ny)) continue;
                if (map[nx][ny] == 1) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;

                if (map[nx][ny] == 0) {
                    infectedEmpty++;
                    maxTime = Math.max(maxTime, dist[nx][ny]);
                    if (infectedEmpty == emptyTotal) {
                        min = Math.min(min, maxTime);
                        return;
                    }
                }

                q.add(new int[]{nx, ny});
            }
        }
    }


    static void selectViruses(int[] virusIdxs, int start, int count){
        if(count==m){
            bfs(virusIdxs);
            return;
        }
        for (int i = start; i < virusCount; i++) {
            virusIdxs[count] = i;
            selectViruses(virusIdxs, i+1, count+1);
        }
    }

    static boolean isBound(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
}
