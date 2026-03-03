package graph;

import java.util.*;
import java.io.*;

// 18188
public class Baek_18188 {
    static int h, w, n;
    static int sx = 0, sy = 0, ex = 0, ey = 0;
    static char[][] map;
    static char[][] steps;

    static final char[] dir = {'W', 'A', 'S', 'D'};
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, -1, 0, 1};

    static class State{
        int x, y, m;
        char[] route = new char[20];

        public State(int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }

        public State(int x, int y, int m, char[] route, char c) {
            this.x = x;
            this.y = y;
            this.m = m;
            for (int i = 0; i < m-1; i++) {
                this.route[i] = route[i];
            }
            this.route[m-1] = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j]=='D'){
                    sx = i;
                    sy = j;
                }else if(map[i][j]=='Z'){
                    ex = i;
                    ey = j;
                }
            }
        }
        n = Integer.parseInt(br.readLine());
        steps = new char[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            steps[i][0] = st.nextToken().charAt(0);
            steps[i][1] = st.nextToken().charAt(0);
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(sx, sy, 0));
        while (!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int m = cur.m;
            char[] route = cur.route;
            if(x==ex&&y==ey){
                StringBuilder sb = new StringBuilder();
                sb.append("YES\n");
                for (int i = 0; i < m; i++) {
                    sb.append(route[i]);
                }
                System.out.println(sb);
                return;
            }
            if(m==n) continue;
            for (int k = 0; k < 2; k++) {
                char c = steps[m][k];
                int nx = x + DX[direction(c)];
                int ny = y + DY[direction(c)];
                if(!isBound(nx, ny)||map[nx][ny]=='@') continue;
                q.add(new State(nx, ny, m+1, route, c));
            }
        }
        System.out.println("NO");
    }

    static boolean isBound(int x, int y){
        return 0<=x&&x<h&&0<=y&&y<w;
    }

    static int direction(char c){
        if(c=='W') return 0;
        if(c=='A') return 1;
        if(c=='S') return 2;
        if(c=='D') return 3;
        return 1;
    }
}
