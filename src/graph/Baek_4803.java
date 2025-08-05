package graph;

import java.util.*;
import java.io.*;

// 4803
/**
 * 입력
 * - 1 <= n <= 500, m <= n(n-1)/2 (최대: 499*250 = 125000 - 250 = 124750)
 *
 * 문제 풀이
 * 1. 테스트 케이스가 여러개 주어지므로 while문으로 입력받기
 * 2. 정점 수 n과 간선 수 m을 입력받고, 인접 리스트로 무방향 그래프 구성
 * 3. visited[] 배열을 사용하여 각 연결 요소별로 BFS 탐색 수행
 *    - 이미 방문한 노드는 건너뜀
 *    - BFS 탐색 중 부모가 아닌 노드를 다시 방문하면 사이클이 존재하므로 트리 아님
 * 4. 사이클이 없는 연결 요소(트리)가 있다면 개수 t를 증가시킴
 * 5. 트리 개수에 따라 출력 문장을 다르게 구성하여 결과 출력
 *
 * 시간복잡도: O(N + M) (N: 정점 수, M: 간선 수)
 * 공간복잡도: O(N + M) (그래프 + 방문 배열)
 */
public class Baek_4803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            int t = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,0});
                visited[i] = true;
                boolean flag = true;
                while(!q.isEmpty()){
                    int[] node = q.poll();
                    int cur = node[0];
                    int prev = node[1];
                    for(int next: graph[cur]){
                        if(visited[next]) {
                            if(next!=prev) {
                                flag = false;
                            }
                        }else{
                            visited[next] = true;
                            q.add(new int[]{next, cur});
                        }
                    }
                }
                if(flag) t++;
            }
            sb.append("Case ").append(tc++).append(": ");
            if(t == 0) {
                sb.append("No trees.\n");
            }else if(t==1){
                sb.append("There is one tree.\n");
            }else{
                sb.append("A forest of ").append(t).append(" trees.\n");
            }
        }
        System.out.println(sb);
    }
}
