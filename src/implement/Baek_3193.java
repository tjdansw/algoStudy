package implement;

import java.util.*;
import java.io.*;

// 3193
public class Baek_3193 {
    static int n, k, bX, bY;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j]=='L'){
                    bX = i;
                    bY = j;
                    map[i][j] = '.';
                }
            }
        }
        int p = 0;
        for (int i = 0; i < k; i++) {
            int temp = (br.readLine().equals("L")?-1:1);
            p = (p+4+temp)%4;
            moveBall(p);
        }
        map[bX][bY] = 'L';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i, y = j;
                if (p == 0) {
                    x = i; y = j;
                } else if (p == 1) {
                    x = n - 1 - j; y = i;
                } else if (p == 2) {
                    x = n - 1 - i; y = n - 1 - j;
                } else {
                    x = j; y = n - 1 - i;
                }
                sb.append(map[x][y]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void moveBall(int p){
        int nx = bX+dx[p];
        int ny = bY+dy[p];
        while (isBound(nx, ny)&&map[nx][ny]!='X'){
            bX = nx;
            bY = ny;
            nx = bX+dx[p];
            ny = bY+dy[p];
        }
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
}
