package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1202 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k;
    static int[] bags;
    static int[][] jewels;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new int[n][2];
        bags = new int[k];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 보석 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 보석 가격
        }
        Arrays.sort(jewels, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int i = 0; i <k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long total= 0;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (idx < n && jewels[idx][0] <= bags[i]) {
                pq.offer(jewels[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
