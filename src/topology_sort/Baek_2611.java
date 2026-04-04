package topology_sort;

import java.util.*;
import java.io.*;

// 2611
public class Baek_2611 {
    static int n, m;
    static HashMap<Integer, Integer>[] graph;
    static int[] indegree, dp, prev, toOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new HashMap[n+1];
        indegree = new int[n+1];
        dp = new int[n+1];
        prev = new int[n+1];
        toOne = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(q==1){
                toOne[p] = Math.max(toOne[p], r);
                continue;
            }
            if(!graph[p].containsKey(q)){
                indegree[q]++;
            }
            graph[p].put(q, Math.max(graph[p].getOrDefault(q, 0), r));
        }

        dp = new int[n+1];
        prev = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next:graph[cur].keySet()){
                int len = graph[cur].get(next);
                if(dp[next] < dp[cur]+len){
                    dp[next] = dp[cur]+len;
                    prev[next] = cur;
                }
                if(--indegree[next]==0){
                    q.add(next);
                }
            }
        }
        int lastNode = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(toOne[i]==0) continue;
            int len = dp[i]+toOne[i];
            if(max<len){
                max = len;
                lastNode = i;
            }
        }

        ArrayList<Integer> route = new ArrayList<>();
        route.add(1);
        while (true){
            route.add(lastNode);
            if(lastNode==1) break;
            lastNode = prev[lastNode];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');
        for(int i = route.size()-1;i>=0;i--){
            sb.append(route.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
