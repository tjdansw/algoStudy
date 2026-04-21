package dfs;

import java.util.*;
import java.io.*;

//1007
public class Baek_1007 {
    static int n;
    static double min;
    static int totalX, totalY;
    static int[][] points = new int[20][2];
    static double[][] lens = new double[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            n = Integer.parseInt(br.readLine());
            totalX = 0;
            totalY = 0;
            min = Double.MAX_VALUE;

            // O(n)
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
                totalX += points[i][0];
                totalY += points[i][1];
            }

            dfs(0, 0, 0, 0);

            answer.append(min).append('\n');
        }
        System.out.println(answer);
    }

    static void dfs(int cur, int count, int subSumX, int subSumY){
        if(count==n/2){
            long x = 2*subSumX - totalX;
            long y = 2*subSumY - totalY;
            double len = Math.sqrt(x*x+y*y);
            min = Math.min(min, len);
            return;
        }

        if(cur==n||count+(n-cur)<n/2) return;

        dfs(cur+1, count+1, subSumX+points[cur][0], subSumY+points[cur][1]);
        dfs(cur+1, count, subSumX, subSumY);
    }
}
