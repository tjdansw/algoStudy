package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_11000 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        );

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b});
        }

        PriorityQueue<Integer> classRoom = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if(!classRoom.isEmpty()&&classRoom.peek() <= next[0]){
                classRoom.poll();
            }
            classRoom.add(next[1]);
        }

        System.out.println(classRoom.size());
    }
}
