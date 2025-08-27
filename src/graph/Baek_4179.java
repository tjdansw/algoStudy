package graph;

import java.util.*;
import java.io.*;

// 4179
public class Baek_4179 {
    static final int MAX = 1_000_000;
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class JiHun{
        int x, y;
        int time;

        public JiHun(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];
        JiHun jh = null;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = line.charAt(j);
                if(c=='#'){
                    map[i][j] = -1;
                }else if(c=='J'){
                    jh = new JiHun(i, j,1);
                    visited[i][j] = true;
                }else if(c=='F'){
                    map[i][j] = 1;
                }else{
                    map[i][j] = MAX;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==1){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0; i < 4; i++){
                int row = p[0] + dx[i];
                int col = p[1] + dy[i];
                if(isBound(row, col)&&map[row][col]==MAX){
                    map[row][col] = map[p[0]][p[1]] + 1;
                    q.add(new int[]{row,col});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        PriorityQueue<JiHun> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time, b.time));
        pq.add(jh);
        while(!pq.isEmpty()){
            JiHun cur = pq.poll();
            if(cur.x==0||cur.x==r-1||cur.y==0||cur.y==c-1){
                min = Math.min(min,cur.time);
                continue;
            }
            int nextTime = cur.time+1;
            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(isBound(x, y)&&map[x][y]>nextTime&&!visited[x][y]){
                    visited[x][y] = true;
                    pq.add(new JiHun(x, y,nextTime));
                }
            }
        }
        System.out.println(min==Integer.MAX_VALUE?"IMPOSSIBLE":min);
    }

    static boolean isBound(int row, int col){
        return row>=0 && row<r && col>=0 && col<c;
    }
}
