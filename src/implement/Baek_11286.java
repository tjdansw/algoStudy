package implement;

import java.util.*;
import java.io.*;

// 11286
public class Baek_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(Math.abs(a)==Math.abs(b)) return Integer.compare(a, b);
            return Integer.compare(Math.abs(a), Math.abs(b));
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                sb.append(pq.isEmpty()?0:pq.poll()).append('\n');
            }else{
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
