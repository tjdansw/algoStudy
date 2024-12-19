package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_15663 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static StringBuilder temp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_15663.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int dept) {
        if(dept == m) {
            temp = new StringBuilder();
            for(int i = 0 ; i < m ; i++) temp.append(nums[i]).append(' ');
            if(!set.contains(temp.toString())){
                set.add(temp.toString());
                sb.append(temp.toString()).append('\n');
            }
            return;
        }
        for(int i = 0;i<list.size();i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[dept] = list.get(i);
            dfs(dept+1);
            visited[i] = false;
        }
    }
}
