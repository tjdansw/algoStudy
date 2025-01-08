package dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_17386 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m, a, b, t;
    static boolean[] isVisible;
    static long[] dp;
    static HashMap<Integer, List<Node>> map = new HashMap<>();
    static List<Node> list;
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Long.compare(o1.len, o2.len);
        }
    });

    static class Node{
        int endPoint;
        long len;

        public Node(int endPoint, long len) {
            this.endPoint = endPoint;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_17386.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisible = new boolean[n];
        dp = new long[n];
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[n-1] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) isVisible[i] = st.nextToken().equals("1");

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(new Node(b, t));
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(new Node(a, t));
        }

        pq.add(new Node(n-1,0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (dp[current.endPoint] < current.len||!map.containsKey(current.endPoint)) continue;
            for(Node prev : map.get(current.endPoint)) {
                if(!isVisible[prev.endPoint]&&dp[prev.endPoint]>dp[current.endPoint]+prev.len) {
                    dp[prev.endPoint]=dp[current.endPoint]+prev.len;
                    pq.add(new Node(prev.endPoint, dp[prev.endPoint]));
                }
            }
        }
        System.out.println(dp[0]==Long.MAX_VALUE?-1:dp[0]);
    }
}
