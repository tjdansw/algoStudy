package implement;

import java.util.*;
import java.io.*;

// 2638
public class Baek_2638 {
    static int n, m, p=0;
    static int[][][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[2][n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[p][i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag=100, cnt;
        while(flag!=0){
            flag = 0;
            bfs();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[p%2][i][j] < 1){
                        map[((p+1)%2)][i][j] = 0;
                        continue;
                    }
                    flag++;
                    cnt = 0;
                    for(int k = 0; k < 4; k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(isBound(x,y)&&map[p%2][x][y]==-1){
                            cnt++;
                        }
                    }
                    map[((p+1)%2)][i][j] = cnt>1?0:1;
                }
            }
            p++;
        }
        System.out.println(p-1);
    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int k = 0; k < 4; k++){
                int x = cur[0]+dx[k];
                int y = cur[1]+dy[k];
                if(isBound(x,y)&&map[p%2][x][y]==0){
                    map[p%2][x][y]=-1;
                    q.add(new int[]{x,y});
                }
            }
        }
    }

    private static boolean isBound(int x,int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
}
