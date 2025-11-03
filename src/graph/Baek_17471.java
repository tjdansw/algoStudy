package graph;

import java.util.*;
import java.io.*;

// 17471
public class Baek_17471 {
    static final int MAX = 1001;
    static int n, min = MAX;
    static int[] population;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        population = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n/2; i++) {
            dfs(i, 0, 1,new boolean[n+1]);
        }

        System.out.println(min==MAX?-1:min);
    }

    static void dfs(int target, int dept, int start, boolean[] checkNodes){
        if(target==dept){
            boolean[] reverseCheckNodes = solveReverse(checkNodes);
            if(isConnection(checkNodes)&&isConnection(reverseCheckNodes)){
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= n; i++) {
                    if(checkNodes[i]){
                        sumA+=population[i];
                    }else{
                        sumB+=population[i];
                    }
                }
                min = Math.min(min, Math.abs(sumA-sumB));
            }
            return;
        }

        for(int i = start;i<=n;i++){
            checkNodes[i] = true;
            dfs(target, dept+1, i+1, checkNodes);
            checkNodes[i] = false;
        }
    }

    private static boolean[] solveReverse(boolean[] checkNodes) {
        boolean[] res = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            res[i] = !checkNodes[i];
        }
        return res;
    }


    static boolean isConnection(boolean[] checkNodes){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        for (int i = 1; i <= n; i++) {
            if(checkNodes[i]){
                node = i;
                break;
            }
        }
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next:graph[cur]){
                if(!visited[next]&&checkNodes[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(checkNodes[i]!=visited[i]){
                return false;
            }
        }

        return true;
    }
}
