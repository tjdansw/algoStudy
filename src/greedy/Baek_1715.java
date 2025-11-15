package greedy;

import java.util.*;
import java.io.*;

// 1715
public class Baek_1715 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int total = 0;
        while (pq.size()>1){
            int sum = pq.poll()+pq.poll();
            total+=sum;
            pq.add(sum);
        }
        System.out.println(total);
    }
}
