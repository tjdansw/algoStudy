package floyd_warshall;

import java.util.*;
import java.io.*;

// 2660
public class Baek_2660 {
    static int n;
    static int[][] isFriend;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isFriend = new int[n+1][n+1];
        score = new int[n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(isFriend[i], 100);
            isFriend[i][i] = 0;
        }

        StringTokenizer st;
        int x, y;
        while (true){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x==-1&&y==-1) break;
            isFriend[x][y] = 1;
            isFriend[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (isFriend[i][k] == 100) continue;
                for (int j = 1; j <= n; j++) {
                    if (isFriend[k][j] == 100) continue;
                    int nd = isFriend[i][k] + isFriend[k][j];
                    if (nd < isFriend[i][j]) isFriend[i][j] = nd;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            isFriend[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                isFriend[i][0] = Math.max(isFriend[i][0], isFriend[i][j]);
            }
        }

        int min = 100, cnt = 0;
        for (int i = 1; i <= n ; i++) {
            if(min>isFriend[i][0]){
                min = isFriend[i][0];
                cnt = 1;
            }else if(min==isFriend[i][0]){
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(cnt).append('\n');
        for (int i = 1; i <= n ; i++) {
            if(min == isFriend[i][0]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
}
