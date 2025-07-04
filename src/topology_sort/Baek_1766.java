package topology_sort;

import java.util.*;
import java.io.*;

// 1766
public class Baek_1766 {
    static int n, m;
    // i 번 문제를 풀기 위해 먼저 풀어야하는 문제 리스트
    static HashSet<Integer>[] prerequisiteList;
    // i 번 문제를 우선시로 풀어야하는 문제 리스트
    static ArrayList<Integer>[] postconditionList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        prerequisiteList = new HashSet[n+1];
        postconditionList = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            prerequisiteList[i] =  new HashSet<>();
            postconditionList[i] =  new ArrayList<>();
        }

        int a, b;
        ArrayList<Integer> list;
        for(int i = 0;i < m;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            prerequisiteList[b].add(a);
            postconditionList[a].add(b);
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1;i<=n;i++){
            if(prerequisiteList[i].isEmpty()){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int node = pq.poll();
            sb.append(node).append(' ');
            for(int next: postconditionList[node]){
                prerequisiteList[next].remove(node);
                if(prerequisiteList[next].isEmpty()){
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}

/**
 * 초기에는 선행 조건을 HashSet으로 관리했지만, 단순한 개수 판단에는 indegree 배열로 체크하여 remove 연산을 줄였다
 * => 시간과 공간 모두 최적화할 수 있었음
 * 위상 정렬 문제임을 보자마자 판단하지 못한 점이 아쉽게 다가왔음
 *
 * import java.util.*;
 * import java.io.*;
 *
 * public class Main {
 *     static int n, m;
 *     static List<Integer>[] graph;
 *     static int[] indegree;
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *         n = Integer.parseInt(st.nextToken());
 *         m = Integer.parseInt(st.nextToken());
 *
 *         graph = new ArrayList[n + 1];
 *         indegree = new int[n + 1];
 *         for (int i = 1; i <= n; i++) {
 *             graph[i] = new ArrayList<>();
 *         }
 *
 *         for (int i = 0; i < m; i++) {
 *             st = new StringTokenizer(br.readLine());
 *             int a = Integer.parseInt(st.nextToken());
 *             int b = Integer.parseInt(st.nextToken());
 *             graph[a].add(b);
 *             indegree[b]++;
 *         }
 *
 *         PriorityQueue<Integer> pq = new PriorityQueue<>();
 *         for (int i = 1; i <= n; i++) {
 *             if (indegree[i] == 0) {
 *                 pq.add(i);
 *             }
 *         }
 *
 *         StringBuilder sb = new StringBuilder();
 *         while (!pq.isEmpty()) {
 *             int curr = pq.poll();
 *             sb.append(curr).append(' ');
 *
 *             for (int next : graph[curr]) {
 *                 if (--indegree[next] == 0) {
 *                     pq.add(next);
 *                 }
 *             }
 *         }
 *
 *         System.out.println(sb);
 *     }
 * }
 */
