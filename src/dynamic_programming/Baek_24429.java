package dynamic_programming;

import java.util.*;
import java.io.*;

// 24429
public class Baek_24429 {
    static int n, p;
    static int[][] matrix, dp;
    static ArrayList<int[]> nodeList = new ArrayList<>();
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n+2][n+2];
        dp = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList.add(new int[]{a, b});
        }
        Collections.sort(nodeList, (a, b)->a[0]==b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]));
        nodeList.add(new int[]{n, n});
        int sR = 1, sC = 1;
        dp[1][1] = matrix[1][1];
        for(int[] target:nodeList){
            int tR = target[0];
            int tC = target[1];
            if(!isBound(sR, sC, tR, tC)){
                dp[n][n] = -1;
                break;
            }

            for(int i = sR;i<=tR;i++){
                for (int j = sC; j <= tC; j++) {
                    for (int k = 0; k < 2; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];
                        if(isBound(nr, nc, tR, tC)){
                            dp[nr][nc] = Math.max(dp[nr][nc], dp[i][j] + matrix[nr][nc]);
                        }
                    }
                }
            }
            sR = tR;
            sC = tC;
        }

        System.out.println(dp[n][n]);
    }

    static boolean isBound(int r, int c, int tR, int tC){
        return r<=tR&&c<=tC;
    }
}
