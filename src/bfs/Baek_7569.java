package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7569 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,m,h;
    static int[][][] box, time;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Queue<int[]> q = new LinkedList<int[]>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        time = new int[h][n][m];
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1) {
                        q.add(new int[]{i,j,k});
                        time[i][j][k] = 0;
                    }else{
                        time[i][j][k] = box[i][j][k]==-1?0:-1;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<6;i++){
                int z = cur[0]+dz[i];
                int x = cur[1]+dx[i];
                int y = cur[2]+dy[i];

                if(isBound(x,y,z)&&box[z][x][y]==0) {
                    box[z][x][y]=1;
                    time[z][x][y] = time[cur[0]][cur[1]][cur[2]]+1;
                    q.add(new int[]{z,x,y});
                }
            }
        }
        boolean flag = true;
        int max = 0;
        for(int i=0;i<h&&flag;i++){
            for(int j=0;j<n&&flag;j++){
                for(int k=0;k<m&&flag;k++){
                    max = Math.max(max,time[i][j][k]);
                    if(time[i][j][k]==-1) flag = false;
                }
            }
        }

        System.out.println(flag?max:-1);
    }

    static boolean isBound(int x,int y,int z){
        return !(x<0||x>=n||y<0||y>=m||z<0||z>=h);
    }
}
