package graph;

import java.util.*;
import java.io.*;

// 14442
public class Baek_14442 {
    static int n, m, k;
    static boolean[][] map;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class State{
        int x, y;
        int crushBlockCnt;
        int moveCnt;


        public State(int x, int y, int crushBlockCnt, int moveCnt) {
            this.x = x;
            this.y = y;
            this.crushBlockCnt = crushBlockCnt;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new boolean[n+1][m+1];
        visited = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = (line.charAt(j-1)=='0');
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        if(n==1&&m==1){
            System.out.println(1);
            return;
        }


        visited[1][1] = 0;
        PriorityQueue<State> q = new PriorityQueue<>((a, b)->Integer.compare(a.moveCnt, b.moveCnt));
        q.add(new State(1, 1, 0, 1));
        while (!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;;
            int y = cur.y;
            int crushBlockCnt = cur.crushBlockCnt;
            int moveCnt = cur.moveCnt;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx==n&&ny==m){
                    System.out.println(moveCnt+1);
                    return;
                }

                if(isBound(nx, ny)){
                    // 벽이 아니면
                    if(map[nx][ny]){
                        if(visited[nx][ny] > crushBlockCnt){
                            visited[nx][ny] = crushBlockCnt;
                            q.add(new State(nx, ny, crushBlockCnt, moveCnt+1));
                        }
                    }else{
                        if(crushBlockCnt==k) continue;
                        if(visited[nx][ny] > crushBlockCnt+1){
                            visited[nx][ny] = crushBlockCnt+1;
                            q.add(new State(nx, ny, crushBlockCnt+1, moveCnt+1));
                        }
                    }
                }

            }
        }
        System.out.println(-1);

    }

    static boolean isBound(int x, int y){
        return x>0&&x<=n&&y>0&&y<=m;
    }
}
