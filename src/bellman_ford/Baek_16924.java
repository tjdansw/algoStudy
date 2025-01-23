package bellman_ford;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_16924 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static String line;
    static int n, m,cnt=0;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_16924.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == '*') check(i, j);
            }
        }
        System.out.println(cnt==0?-1:cnt);
        if(cnt!=0) System.out.println(sb);
    }

    static void check(int x, int y) {
        boolean flag = false;
        for(int len = 1; len <= 3; len++) {
            for(int i = 0;i<4;i++){
                int row = x+dx[i]*len;
                int col = y+dy[i]*len;
                if(!isBound(row,col)||map[row][col] != '*'){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            cnt++;
            sb.append(x+1).append(" ").append(y+1).append(" ").append(len).append("\n");
        }
    }

    static boolean isBound(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }
}
