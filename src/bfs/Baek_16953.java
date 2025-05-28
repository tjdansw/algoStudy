package bfs;

import java.io.*;
import java.util.*;

public class Baek_16953 {
    static long A, B;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{A,1});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long next = cur[0]*10+1;
            if(next==B){
                System.out.println(cur[1]+1);
                return;
            }else if(next<B){
                pq.add(new long[]{next,cur[1]+1});
            }
            next = 2*cur[0];
            if(next==B){
                System.out.println(cur[1]+1);
                return;
            }else if(next<B){
                pq.add(new long[]{next,cur[1]+1});
            }
        }

        System.out.println(-1);
    }
}
