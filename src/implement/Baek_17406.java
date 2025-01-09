package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_17406 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, k, min = Integer.MAX_VALUE;;
    static int[][] map;
    static int[][] operations;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int row, col, init, temp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_17406.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        operations = new int[k][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken());
            operations[i][1] = Integer.parseInt(st.nextToken());
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        dfs(map,new boolean[k],0);
        System.out.println(min);
    }

    static void dfs(int[][] arr,boolean[] visited, int dept){
        if(dept==k){
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= m; j++) {
                    sum += arr[i][j];
                }
                min = Math.min(min, sum);
            }
            return;
        }
        for(int i = 0;i<k;i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(operation(copyArr(arr),operations[i][0],operations[i][1],operations[i][2]),visited,dept+1);
            visited[i] = false;
        }
    }

    static int[][] operation(int[][] arr,int r,int c,int s) {
        while (s > 0) {
            row = r - s;
            col = c - s;
            init = arr[row][col];
            for (int idx = 0; idx < 4; idx++) {
                for(int i = 0;i<2*s;i++){
                    row += dx[idx];
                    col += dy[idx];
                    temp = arr[row][col];
                    arr[row][col] = init;
                    init = temp;
                }
            }
            s--;
        }
        return arr;
    }

    static int[][] copyArr(int[][] arr){
        int[][] copyArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copyArr;
    }
}
