package divide_conquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2630 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, whiteCnt = 0, blueCnt = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2630.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        dfs(new int[]{n,n} , new int[]{0,0});

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void dfs(int[] x, int[] y) {
        int midX = (x[0] + y[0])/2;
        int midY = (x[1] + y[1])/2;
        int areaSub = map[x[0]][x[1]]-map[y[0]][x[1]]-map[x[0]][y[1]]+map[y[0]][y[1]];
        if(areaSub == 0){
            whiteCnt++;
        }else if(areaSub == (x[0]-y[0])*(x[0]-y[0])){
            blueCnt++;
        }else{
            dfs(x,new int[]{midX,midY});
            dfs(new int[]{midX,x[1]},new int[]{y[0],midY});
            dfs(new int[]{x[0],midY},new int[]{midX,y[1]});
            dfs(new int[]{midX,midY},y);
        }
    }
}
