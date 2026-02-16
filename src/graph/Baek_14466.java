package graph;

import java.util.*;
import java.io.*;

// 14466
public class Baek_14466 {
    static int N, K, R;
    static boolean[][][] hasRoad;
    static int[][] indexOfMap;
    static int[] indexOfCows;
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        hasRoad = new boolean[N+1][N+1][4];
        indexOfMap = new int[N+1][N+1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int rr = Integer.parseInt(st.nextToken());
            int cc = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                int nr = r + DX[j];
                int nc = c + DY[j];
                if(nr==rr&&nc==cc){
                    hasRoad[r][c][j] = true;
                    hasRoad[rr][cc][(j+2)%4] = true;
                    break;
                }
            }
        }
        int idx = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(indexOfMap[i][j]>0) continue;
                indexOfMap[i][j] = ++idx;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + DX[k];
                        int ny = y + DY[k];
                        if(!hasRoad[x][y][k]&&isBound(nx, ny)&&indexOfMap[nx][ny]==0){
                            indexOfMap[nx][ny] = idx;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        indexOfCows = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            indexOfCows[i] = indexOfMap[x][y];
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            for (int j = i+1; j < K; j++) {
                if(indexOfCows[i]!=indexOfCows[j]) answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isBound(int x, int y){
        return 0<x&&x<=N&&0<y&&y<=N;
    }
}
