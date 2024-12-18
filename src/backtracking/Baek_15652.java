package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15652 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15652.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];

        dfs(0,1);
        System.out.println(sb);
    }
    static void dfs(int dept, int next) {
        if(dept == m) {
            for(int i = 0 ; i < m ; i++) sb.append(nums[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = next;i<=n;i++){
            nums[dept] = i;
            dfs(dept+1,i);
        }
    }
}
