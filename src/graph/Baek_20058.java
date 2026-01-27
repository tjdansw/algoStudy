package graph;

import java.util.*;
import java.io.*;

// 20058
public class Baek_20058 {
    static int N, Q, SIZE;
    static int[][] map, temp;
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        SIZE = 1<<N;

        map = new int[SIZE+2][SIZE+2];
        temp = new int[SIZE+2][SIZE+2];
        for (int i = 1; i <= SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int tc = 0; tc < Q; tc++) {
            int l = Integer.parseInt(st.nextToken());
            int len = 1<<l;
            for (int i = 1; i <= SIZE; i+=len) {
                for (int j = 1; j <= SIZE; j+=len) {
                    runFireStorm(i, j, len);
                }
            }
            melt();
        }

        int totalIce = 0;
        int max = 0;
        boolean[][] visited = new boolean[SIZE+1][SIZE+1];
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                totalIce += map[i][j];
                if(map[i][j]==0||visited[i][j]) continue;
                int cnt = 1;
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + DX[k];
                        int ny = y + DY[k];
                        if(isBound(nx, ny)&&!visited[nx][ny]&&map[nx][ny]>0){
                            visited[nx][ny] = true;
                            cnt++;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(totalIce);
        System.out.println(max);
    }

    static void runFireStorm(int sx, int sy, int len){
        int ey = sy+len-1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[sx+j][ey-i] = map[sx+i][sy+j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[sx+i][sy+j] = temp[sx+i][sy+j];
            }
        }
    }

    static void melt(){
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                int cnt = 0;
                if(map[i][j]==0) continue;
                for (int k = 0; k < 4; k++) {
                    if(map[i+DX[k]][j+DY[k]] > 0) cnt++;
                }
                temp[i][j] = cnt>2?0:1;
            }
        }
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                map[i][j] -= temp[i][j];
                map[i][j] = Math.max(map[i][j], 0);
            }
        }
    }

    static boolean isBound(int x, int y){
        return 1<=x&&x<=SIZE&&1<=y&&y<=SIZE;
    }
}
