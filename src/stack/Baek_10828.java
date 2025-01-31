package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_10828 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_10828.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":{
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop":{
                    sb.append(stack.isEmpty()?"-1":stack.pop()).append("\n");
                    break;
                }
                case "size":{
                    sb.append(stack.size()).append("\n");
                    break;
                }
                case "empty":{
                    sb.append(stack.isEmpty()?"1":0).append("\n");
                    break;
                }
                case "top":{
                    sb.append(stack.isEmpty()?"-1":stack.peek()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
