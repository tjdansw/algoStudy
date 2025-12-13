package implement;

import java.util.*;
import java.io.*;

// 2573
public class Baek_2573 {
    static int n, m;
    static int[][] map;
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true){
            year++;
            int maxIcebergHeight = afterOneYear();
            if(maxIcebergHeight == 0){
                year = 0;
                break;
            }
            int icebergCnt = icebergCount();
            if(icebergCnt>1) break;
        }
        System.out.println(year);
    }

    static int afterOneYear(){
        int max = 0;
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0) continue;
                newMap[i][j] = Math.max(0, map[i][j]-riverCount(i, j));
                max = Math.max(max, newMap[i][j]);
            }
        }
        map = newMap;
        return max;
    }

    static int icebergCount(){
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0||visited[i][j]) continue;
                cnt++;
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] current = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = current[0] + DX[k];
                        int ny = current[1] + DY[k];
                        if(isBound(nx, ny)&&map[nx][ny]!=0&&!visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static int riverCount(int x, int y){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if(isBound(nx, ny)&&map[nx][ny]==0){
                cnt ++;
            }
        }
        return cnt;
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
}
