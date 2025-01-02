package topology_sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1005 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t, n, k, start,end ,target;
    static int[] completeTime = new int[1001],dp, degree;
    static HashMap<Integer, ArrayList<Integer>> graph;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1005.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            dp = new int[n+1];
            degree = new int[n+1];
            graph = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for(int i =1; i <= n; i++) completeTime[i] = Integer.parseInt(st.nextToken());
            for(int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                list = graph.getOrDefault(start,new ArrayList<>());
                list.add(end);
                graph.put(start,list);
                degree[end]++;
            }
            target = Integer.parseInt(br.readLine());
            sb.append(topologicalSort()).append("\n");
        }
        System.out.println(sb);
    }

    static int topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                q.add(i);
                dp[i] = completeTime[i];
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();

            if(!graph.containsKey(current)) continue;

            for(Integer next : graph.get(current)) {
                dp[next] = Math.max(dp[next], dp[current] + completeTime[next]);
                degree[next]--;

                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return dp[target];
    }
}
