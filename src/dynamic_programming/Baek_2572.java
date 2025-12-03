package dynamic_programming;

import java.util.*;
import java.io.*;

// 2572
public class Baek_2572 {
    static int n, m, k;
    static char[] cardColors;
    static ArrayList<Edge>[] graph;
    static int[][] dp;

    static class Edge{
        int to;
        char color;

        public Edge(int to, char color) {
            this.to = to;
            this.color = color;
        }
    }

    static class State{
        int step;
        int node;

        public State(int step, int node) {
            this.step = step;
            this.node = node;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cardColors = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cardColors[i] = st.nextToken().charAt(0);
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[m+1];
        dp = new int[n+1][m+1];
        for (int i = 1; i <= m; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[0][1] = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            graph[from].add(new Edge(to, color));
            graph[to].add(new Edge(from, color));
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 1));

        while (!q.isEmpty()){
            State state = q.poll();
            int step = state.step;
            int node = state.node;

            int currentScore = dp[step][node];
            if(currentScore<0||step==n) continue;

            int nextStep = step+1;
            for(Edge e: graph[node]){
                int next = e.to;
                int nextScore = currentScore + (e.color==cardColors[step]?10:0);

                if(nextScore>dp[nextStep][next]){
                    dp[nextStep][next] = nextScore;
                    q.add(new State(nextStep, next));
                }
            }
        }

        int max = 0;
        for(int i = 1;i<= m;i++){
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}