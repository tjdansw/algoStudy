package topology_sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2623 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m,size,prev,current;
    static int[] dp, degree;
    static boolean[] visited;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2623.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        degree = new int[n+1];
        lists = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++) lists[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            prev = Integer.parseInt(st.nextToken());
            for(int j = 1; j < size; j++){
                current = Integer.parseInt(st.nextToken());
                lists[prev].add(current);
                degree[current]++;
                prev = current;
            }
        }
        System.out.println(topologicalSort()?sb:0);

    }
    static boolean topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            if(visited[current]) continue;
            sb.append(current).append("\n");
            visited[current] = true;
            for(Integer next : lists[current]) {
                degree[next]--;

                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}
