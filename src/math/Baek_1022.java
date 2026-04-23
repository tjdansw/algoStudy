package math;

import java.util.*;
import java.io.*;

// 1022
public class Baek_1022 {
    static int r1, c1, r2, c2;
    static int lenX, lenY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        lenX = r2 - r1 + 1;
        lenY = c2 - c1 + 1;

        int[][] result = new int[lenX][lenY];
        int max = 0;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                int r = r1 + i;
                int c = c1 + j;
                int n = Math.max(Math.abs(r), Math.abs(c));
                result[i][j] = 0;
                if(r==n) { // down
                    result[i][j] = (2*n+1)*(2*n+1) - (n-c);
                }else if(c ==-n){ // left
                    result[i][j] = (2*n+1)*(2*n+1) - 2*n - (n-r);
                }else if(r ==-n){ // up
                    result[i][j] = (2*n+1)*(2*n+1) - 4*n - (n+c);
                }else{ // right
                    result[i][j] = (2*n+1)*(2*n+1) - 6*n - (n+r);
                }
                max = Math.max(max , result[i][j]);
            }
        }

        int len = (max+"").length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                answer.append(String.format("%"+len+"d ", result[i][j]));
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
}
