package implement;

import java.util.*;
import java.io.*;

// 17144
public class Baek_17144 {
    static int r, c, t;
    static int[][] map;
    static int[] airPurifier = new int[2];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] reverseDx = {-1,0,1,0};
    static int[] reverseDy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    airPurifier[idx++] = i;
                }
            }
        }

        for(int tc = 0; tc < t; tc++) {
            map = moveFineDust();
            operationAirPurifier();
        }
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                cnt += map[i][j];
            }
        }
        System.out.println(cnt);
    }

    private static void operationAirPurifier() {
        int x = airPurifier[0];
        int y = 0;
        for (int i = 0; i < 4; i++) {
            int prevX, prevY;
            while(true) {
                prevX = x + reverseDx[i];
                prevY = y + reverseDy[i];
                if(!isBound(prevX, prevY)||isAirPurifier(prevX,prevY)||prevX>airPurifier[0]) break;
                map[x][y] = Math.max(map[prevX][prevY],0);
                x= prevX;
                y= prevY;
            }
        }
        map[x][y] = 0;
        map[airPurifier[0]][0] = -1;

        x = airPurifier[1];
        y = 0;
        for (int i = 0; i < 4; i++) {
            int prevX, prevY;
            while(true) {
                prevX = x + dx[i];
                prevY = y + dy[i];
                if(!isBound(prevX, prevY)||isAirPurifier(prevX,prevY)||prevX<airPurifier[1]) break;
                map[x][y] = Math.max(map[prevX][prevY],0);
                x= prevX;
                y= prevY;
            }
        }
        map[x][y] = 0;
        map[airPurifier[1]][0] = -1;
    }

    private static int[][] moveFineDust() {
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] <=0) continue;
                int diffusionCnt = 0;
                int diffusionValue = map[i][j]/5;
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(isBound(x,y)&&(!isAirPurifier(x,y))){
                        diffusionCnt ++;
                        res[x][y] += diffusionValue;
                    }
                }
                map[i][j] -= diffusionCnt*diffusionValue;
                map[i][j] = Math.max(map[i][j], 0);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] <0) continue;
                res[i][j] += map[i][j];
            }
        }
        return res;
    }

    private static boolean isBound(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    private static boolean isAirPurifier(int x, int y) {
        for (int i = 0; i < 2; i++) {
            if(airPurifier[i]==x&&y==0){
                return true;
            }
        }
        return false;
    }
}
