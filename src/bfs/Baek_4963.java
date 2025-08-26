package bfs;

import java.util.*;
import java.io.*;

// 4963
public class Baek_4963 {
    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            int[][] map = new int[w][h];
            for(int i = 0; i < w; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < h; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] visited = new boolean[w][h];
            int cnt = 0;
            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    if(visited[i][j]) continue;
                    cnt += map[i][j];

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int k = 0; k < 8; k++){
                            int x = cur[0] + dx[k];
                            int y = cur[1] + dy[k];
                            if(isBound(x,y)&&!visited[x][y]&&map[x][y]==map[i][j]){
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isBound(int x, int y){
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}
