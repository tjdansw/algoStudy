package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_13334 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, d, max =0;
    static ArrayList<int[]> list = new ArrayList<>();
    static PriorityQueue<int[]> pq;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/implement.Baek_13334.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{Math.min(a,b), Math.max(a,b)});
        }
        d = Integer.parseInt(br.readLine());
        Collections.sort(list, (a,b)->Integer.compare(a[1], b[1]));

        pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] node: list){
            if(node[1]-node[0] > d) continue;
            while (!pq.isEmpty() && node[1]-pq.peek()[0] > d) {
                pq.poll();
            }

            pq.add(node);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}
