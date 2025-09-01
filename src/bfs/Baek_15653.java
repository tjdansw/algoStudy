package bfs;

import java.util.*;
import java.io.*;

// 15653
public class Baek_15653 {
    static int n, m;
    static int[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class State{
        int rR, rC;
        int bR, bC;
        int moveCnt;

        public State(int rR, int rC, int bR, int bC, int moveCnt) {
            this.rR = rR;
            this.rC = rC;
            this.bR = bR;
            this.bC = bC;
            this.moveCnt = moveCnt;
        }
    }

    static class MoveResult{
        int r, c, moved;
        boolean isHole;

        public MoveResult(int r, int c, int moved, boolean isHole) {
            this.r = r;
            this.c = c;
            this.moved = moved;
            this.isHole = isHole;
        }
    }

    static MoveResult roll(int sR, int sC, int dir){
        int r = sR, c = sC;
        int moveCnt = 0;

        while (true){
            int nR = r + dx[dir];
            int nC = c + dy[dir];
            if(map[nR][nC] == 1) break;
            r = nR;
            c = nC;
            moveCnt++;
            if(map[r][c] == 2) return new MoveResult(r, c, moveCnt,true);
        }
        return new MoveResult(r,c,moveCnt,false);
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][n][m];

        int rR = 0, rC = 0, bR = 0, bC = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                // 0    1     2     3           4
                // 빈칸  벽    구멍   빨간 구슬    파란 구슬
                if(c=='#'){
                    map[i][j] = 1;
                }else if(c=='O'){
                    map[i][j] = 2;
                }else if(c=='R'){
                    rR = i;
                    rC = j;
                }else if(c=='B'){
                    bR = i;
                    bC = j;
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(rR,rC,bR,bC, 0));
        visited[rR][rC][bR][bC] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            for(int k = 0; k < 4; k++) {
                MoveResult red = roll(cur.rR, cur.rC, k);
                MoveResult blue = roll(cur.bR, cur.bC, k);

                if(blue.isHole) continue;
                if(red.isHole){
                    System.out.println(cur.moveCnt+1);
                    return;
                }

                int nRR = red.r, nRC = red.c;
                int nBR = blue.r, nBC = blue.c;

                if(nRR == nBR && nRC == nBC){
                    if(red.moved > blue.moved){
                        nRR -= dx[k];
                        nRC -= dy[k];
                    }else{
                        nBR -= dx[k];
                        nBC -= dy[k];
                    }
                }

                if(!visited[nRR][nRC][nBR][nBC]){
                    visited[nRR][nRC][nBR][nBC] = true;
                    q.add(new State(nRR, nRC, nBR, nBC, cur.moveCnt+1));
                }
            }
        }
        System.out.println(-1);
    }
}
