package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9466 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int T, n, cnt;
    static int[] student = new int[100001];
    static boolean[] checked,visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_9466.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            checked = new boolean[n+1];
            visited = new boolean[n+1];
            cnt = n;

            st = new StringTokenizer(br.readLine());
            for(int i = 1;i<=n;i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1;i<=n;i++) {
                if(checked[i]) continue;
                dfs(i);
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int current) {
        int next = student[current];
        if(visited[current]){
            checked[current] = true;
            cnt--;
        }else{
            visited[current] = true;
        }

        if(!checked[next]){
            dfs(next);
        }

        visited[current] = false;
        checked[current] = true;
    }
}
