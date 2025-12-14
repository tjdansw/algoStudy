package brute_force;

import java.util.*;
import java.io.*;

// 15683
public class Baek_15683 {
    static int n, m, cctvCnt = 0, min;
    static int[][] map;
    static boolean[][] isChecked;
    static final int[][] cctvs = new int[8][2];
    static final int[] operationCount = {0, 4, 2, 4, 4, 1};
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isChecked = new boolean[n][m];
        min = n*m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                isChecked[i][j] = map[i][j]>0;
                if(map[i][j]>0&&map[i][j]<6){
                    cctvs[cctvCnt][0] = i;
                    cctvs[cctvCnt++][1] = j;
                }
            }
        }
        dfs(0);
        System.out.println(min);
    }

    static void dfs(int cctvNum){
        if(cctvNum==cctvCnt){
            int unCheckedCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!isChecked[i][j]){
                        unCheckedCount++;
                    }
                }
            }
            min = Math.min(min, unCheckedCount);
            return;
        }
        int x = cctvs[cctvNum][0];
        int y = cctvs[cctvNum][1];
        int type = map[x][y];
        for(int i = 0;i<operationCount[type];i++){
            boolean[][] tmep = operationCCTV(x, y, i);
            dfs(cctvNum+1);
            changePrevState(tmep);
        }
    }

    static boolean[][] operationCCTV(int x, int y, int d){
        boolean[][] temp = new boolean[n][m];
        int type = map[x][y];
        int nx, ny;
        if(type==1){
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
        }else if(type == 2){
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+2)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
        }else if(type == 3){
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
        }else if(type == 4){
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
        }else if(type == 5){
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
            d = (d+1)%4;
            nx = x + DX[d];
            ny = y + DY[d];
            while (isBound(nx, ny)&&map[nx][ny]!=6){
                if(!isChecked[nx][ny]){
                    temp[nx][ny] = true;
                }
                isChecked[nx][ny] = true;
                nx = nx + DX[d];
                ny = ny + DY[d];
            }
        }
        return temp;
    }

    static void changePrevState(boolean[][] temp){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(temp[i][j]){
                    isChecked[i][j] = false;
                    temp[i][j] = false;
                }
            }
        }
    }

    static boolean isBound(int x, int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
}
