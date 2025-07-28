package implement;

import java.util.*;
import java.io.*;

// 1966
public class Baek_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                pq.add(nums[i]);
            }
            boolean[] visited = new boolean[n];
            int i=-1, cnt = 1;
            while(true){
                i = (i+1)%n;
                if(visited[i]){
                    continue;
                }
                if(pq.peek()==nums[i]){
                    if(i == m){
                        sb.append(cnt).append("\n");
                        break;
                    }else{
                        pq.poll();
                        visited[i] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
