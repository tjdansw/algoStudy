package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_1927 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1927.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            if(x==0){
                sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}
