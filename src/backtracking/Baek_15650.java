package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15650 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr = new int[8];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15650.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(1,0);
        System.out.println(sb);
    }

    static void bfs(int next,int dept) {
        if(dept == m) {
            for(int i = 0 ; i < m ; i++) sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = next; i <= n; i++) {
            arr[dept] = i;
            bfs(i+1, dept+1);
        }
    }
}
