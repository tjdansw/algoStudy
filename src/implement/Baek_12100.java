package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12100 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, max = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_12100.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int dept, int[][] temp) {
        if (dept == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, temp[i][j]);
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            dfs(dept + 1, solve(temp, i));
        }
    }

    static int[][] solve(int[][] temp, int direction) {
        int[][] arr = new int[n][n];
        if (direction % 2 == 0) {
            for (int j = 0; j < n; j++) {
                int current = direction==0?n-1:0;
                int idx = current;
                int term =1;
                while(current >=0&&current <n) {
                    if(temp[current][j]==0){
                        current+=dx[direction];
                    }else if(isBound(current+term*dx[direction])&&temp[current+term*dx[direction]][j]==0){
                        term++;
                    }
                    else if(isBound(current+term*dx[direction])&&temp[current][j]==temp[current+term*dx[direction]][j]) {
                        arr[idx][j] = temp[current][j]*2;
                        idx += dx[direction];
                        current+=(term+1)*dx[direction];
                        term=1;
                    }else{
                        arr[idx][j] = temp[current][j];
                        idx += dx[direction];
                        current+=(term)*dx[direction];
                        term=1;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                int current = direction==1?0:n-1;
                int idx = current;
                int term =1;
                while(current >=0&&current <n) {
                    if(temp[i][current]==0){
                        current+=dy[direction];
                    }else if(isBound(current+term*dy[direction])&&temp[i][current+term*dy[direction]]==0){
                        term++;
                    }
                    else if(isBound(current+term*dy[direction])&&temp[i][current]==temp[i][current+term*dy[direction]]) {
                        arr[i][idx] = temp[i][current]*2;
                        idx+=dy[direction];
                        current+=(term+1)*dy[direction];
                        term=1;
                    }else{
                        arr[i][idx] = temp[i][current];
                        idx+=dy[direction];
                        current+=(term)*dy[direction];
                        term=1;
                    }
                }
            }
        }
        return arr;
    }

    static boolean isBound(int x){
        return x >= 0 && x < n;
    }
}
