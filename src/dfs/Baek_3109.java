package dfs;

import java.io.*;
import java.util.StringTokenizer;

// 3109
public class Baek_3109 {
    static int r, c, cnt=0;
    static boolean[][] map, visited;
    static int[] dx = {-1, 0, 1};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new boolean[r][c];
        visited = new boolean[r][c];
        String line;
        for(int i=0;i<r;i++){
            line=br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = line.charAt(j)=='.';
            }
        }

        for(int i = 0;i<r;i++){
            flag=false;
            dfs(i,0);
        }

        System.out.println(cnt);
    }

    private static void dfs(int n, int m) {
        if(flag){
            return;
        }
        visited[n][m] = true;
        if(m == c-1){
            cnt++;
            flag = true;
            return;
        }
        for(int i = 0;i<3;i++){
            int nextRow = n+dx[i];
            int nextCol = m+1;
            if(nextRow>=0 && nextRow<r && !visited[nextRow][nextCol] && map[nextRow][nextCol]){
                dfs(nextRow,nextCol);
            }
        }
    }
}
