package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1764 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n ,m;
    static HashSet<String> set = new HashSet<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1764.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0;i<n;i++){
            set.add(br.readLine());
        }
        for(int i = 0;i<m;i++){
            String name = br.readLine();
            if(set.contains(name)){
                pq.add(name);
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
