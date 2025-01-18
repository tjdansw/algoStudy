package bellman_ford;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1865 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, n, m, w;
    static int start, end, time;
    static ArrayList<int[]>[] list;
    static long[] dp;
    static Queue<Integer> q;
    static boolean[] inQueue;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1865.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            // Read edges
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                list[start].add(new int[]{end, time});
                list[end].add(new int[]{start, time});
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                time = -Integer.parseInt(st.nextToken());

                list[start].add(new int[]{end, time});
            }

            boolean flag = false;
            dp = new long[n + 1];

            for (int i = 1; i <= n && !flag; i++) {
                Arrays.fill(dp, Integer.MAX_VALUE);
                dp[i] = 0;

                q = new LinkedList<>();
                inQueue = new boolean[n + 1];
                q.offer(i);
                inQueue[i] = true;

                int count = 0;
                while (!q.isEmpty() && count <= n) {
                    int size = q.size();
                    count++;

                    for (int j = 0; j < size; j++) {
                        int current = q.poll();
                        inQueue[current] = false;

                        for (int[] next : list[current]) {
                            if (dp[next[0]] > dp[current] + next[1]) {
                                dp[next[0]] = dp[current] + next[1];
                                if (!inQueue[next[0]]) {
                                    q.offer(next[0]);
                                    inQueue[next[0]] = true;
                                }
                            }
                        }
                    }

                    if (count > n) {
                        flag = true;
                        break;
                    }
                }
            }

            sb.append(flag ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }
}
