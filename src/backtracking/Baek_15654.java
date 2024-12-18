package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_15654 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static int[] nums, arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15654.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        visited = new boolean[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int dept){
        if(dept == m){
            for(int i =0;i<m;i++) sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = 0;i<n;i++){
            if(visited[i]) continue;
            arr[dept] = nums[i];
            visited[i] = true;
            dfs(dept+1);
            visited[i] = false;
        }
    }
}
