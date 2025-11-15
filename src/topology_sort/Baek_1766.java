package topology_sort;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

// 1766
public class Baek_1766 {
    static int n, m;
    static int[] indegree;
    static ArrayList<Integer>[] nextProblems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n+1];
        nextProblems = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) nextProblems[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nextProblems[a].add(b);
            indegree[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i]==0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(' ');
            for(int next: nextProblems[cur]){
                indegree[next]--;
                if(indegree[next]==0) pq.add(next);
            }
        }
        System.out.println(sb);
    }
}
