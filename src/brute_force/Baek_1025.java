package brute_force;

import java.util.*;
import java.io.*;

// 1025
public class Baek_1025 {
    static int max = -1;
    static int n, m;
    static int[][] map;
    static final int[] DX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] DY = {0, 1, 1, 1, 0, -1, -1, -1};

    static HashSet<Integer> squareNumbers = new HashSet<>();
    static{
        for (int i = 0; i <= 31622; i++) {
            squareNumbers.add(i*i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 1; l < 10; l++) {
                        for (int o = 1; o < 10; o++) {
                            solveValue(i, j, DX[k]*l, DY[k]*o, map[i][j], 10);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    static void solveValue(int x, int y, int dx, int dy, int value, int pow){
        if(isSquareNumber(value)){
            max = Math.max(max, value);
        }
        int nx = x + dx;
        int ny = y + dy;
        if(isBound(nx, ny)){
            solveValue(nx, ny, dx, dy, value+map[nx][ny]*pow, pow*10);
        }
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }

    static boolean isSquareNumber(int number){
        return squareNumbers.contains(number);
    }
}
