package implement;

import java.util.*;
import java.io.*;

// 16954
public class Baek_16954 {
    static char[][][] map = new char[20][8][8];
    static final int[] DX = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] DY = {0, -1, 0, 1, 1, 1, 0, -1, -1};

    static class State{
        int time, x, y;

        public State(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) map[0][i] = br.readLine().toCharArray();

        for (int t = 1; t < 20; t++) {
            map[t][0] = "........".toCharArray();
            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    map[t][i][j] = map[t-1][i-1][j];
                }
            }
        }

        boolean canArrive = false;
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 7, 0));
        while (!q.isEmpty()&&!canArrive){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int time = cur.time;
            int next = time+1;

            for (int i = 0; i < 9; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(isBound(nx, ny)&&map[time][nx][ny]=='.'&&map[next][nx][ny]=='.'&&next<20){
                    if(nx == 0&&ny==7) canArrive = true;
                    q.add(new State(next, nx, ny));
                }
            }
        }

        System.out.println(canArrive?1:0);
    }

    private static boolean isBound(int x, int y){
        return 0<=x&&x<8&&0<=y&&y<8;
    }
}
