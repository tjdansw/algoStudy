package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_10845 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_10845.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":{
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop":{
                    sb.append(dq.isEmpty()?"-1":dq.pollFirst()).append("\n");
                    break;
                }
                case "size":{
                    sb.append(dq.size()).append("\n");
                    break;
                }
                case "empty":{
                    sb.append(dq.isEmpty()?"1":0).append("\n");
                    break;
                }
                case "front":{
                    sb.append(dq.isEmpty()?"-1":dq.peekFirst()).append("\n");
                    break;
                }
                case "back":{
                    sb.append(dq.isEmpty()?"-1":dq.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
