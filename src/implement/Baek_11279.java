package implement;

import java.util.*;
import java.io.*;

public class Baek_11279 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
                continue;
            }
            pq.add(num);
        }

        System.out.println(sb);
    }
}
