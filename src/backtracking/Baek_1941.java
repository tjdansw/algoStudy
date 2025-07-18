package backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;

class Baek_1941 {
    static char[][] map =  new char[5][5];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int res = 0;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        for(int i = 0;i<5;i++){
            line = br.readLine();
            for(int j = 0;j<5;j++){
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0, 0, 0, new boolean[5][5]);

        System.out.println(res);
    }

    private static void dfs(int x,int y, int sX,int sY,int cnt,boolean[][] visited){
        if(cnt==7){
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sX,sY});
            int t = map[sX][sY]=='S'?1:0;
            int p = 1;
            boolean[][] isChecked = new boolean[5][5];
            isChecked[sX][sY] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int i = 0;i<4;i++){
                    int nx = cur[0]+dx[i];
                    int ny = cur[1]+dy[i];
                    if(isBound(nx,ny)&&visited[nx][ny]&&!isChecked[nx][ny]){
                        isChecked[nx][ny] = true;
                        t += map[nx][ny]=='S'?1:0;
                        p++;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            if(p==7&&t>3){
                res++;
            }
            return;
        }
        if(x>4){
            return;
        }
        int nextY = (y+1)%5;
        int nextX = x+(y+1)/5;
        if(cnt==0){
            dfs(nextX, nextY, nextX, nextY, cnt, visited);
        }else{
            dfs(nextX, nextY, sX, sY, cnt, visited);
        }
        visited[x][y] = true;
        if(cnt==0){
            dfs(nextX, nextY, x, y, cnt+1, visited);
        }else{
            dfs(nextX, nextY, sX, sY, cnt+1, visited);
        }
        visited[x][y] = false;
    }


    private static boolean isBound(int x,int y){
        return x>=0&&x<5&&y>=0&&y<5;
    }
}