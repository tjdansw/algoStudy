package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_23757 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, m;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_23757.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m&&flag; i++){
            int child = Integer.parseInt(st.nextToken());
            int cnt = pq.poll();
            if(child>cnt) flag = false;
            else if(child<cnt) pq.add(cnt-child);
        }

        System.out.println(flag?1:0);
    }
}
