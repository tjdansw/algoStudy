package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_4108 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int r,c;
    static String[] map = new String[100];
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_4108.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(r == 0 && c == 0) break;

            for(int i = 0; i < r; i++) {
                map[i] = br.readLine();
            }
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    char element = map[i].charAt(j);
                    sb.append(element=='*'?"*":checkMineCnt(i,j));
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    static boolean isBound(int x, int y) {
        return !(x < 0 || y < 0 || x >= r || y >= c);
    }
    static int checkMineCnt(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            int row = x+dx[i];
            int col = y+dy[i];
            if(isBound(row, col)&&map[row].charAt(col)=='*') {
                cnt++;
            }
        }
        return cnt;
    }
}
