package topology_sort;

import java.util.*;
import java.io.*;

// 9470
public class Baek_9470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[m+1];
            int[] indegree = new int[m+1];
            int[] strahler = new int[m+1];
            boolean[] isChecked = new boolean[m+1];

            for(int i = 1; i <= m; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= m; i++) {
                if(indegree[i] == 0) {
                    strahler[i] = 1;
                    q.add(i);
                }
            }

            int max = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();
                max = Math.max(max, strahler[cur]);
                for(int next: graph[cur]) {
                    indegree[next]--;
                    if(isChecked[next]&&strahler[next] == strahler[cur]) {
                        strahler[next]++;
                        isChecked[next] = false;
                    }else{
                        strahler[next] = Math.max(strahler[cur], strahler[next]);
                        isChecked[next] = true;
                    }
                    if(indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
            sb.append(tc).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
    }
}
