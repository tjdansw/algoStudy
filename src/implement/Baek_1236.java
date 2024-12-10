package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1236 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,m;
    static boolean[] row,col;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1236.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        row = new boolean[n];
        col = new boolean[m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                if(line.charAt(j) == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        int rCnt = 0, cCnt = 0;
        for(int i = 0; i < n; i++) rCnt += row[i] ? 0 : 1;
        for(int j = 0; j < m; j++) cCnt += col[j] ? 0 : 1;
        System.out.println(Math.max(rCnt, cCnt));
    }
}
