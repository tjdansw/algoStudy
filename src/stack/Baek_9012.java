package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_9012 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static boolean flag;
    static String line;
    static Stack<Character> stack = new Stack<Character>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_9012.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.clear();
            line = br.readLine();
            flag = true;
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == '(') stack.push(line.charAt(j));
                else{
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            sb.append(flag&&stack.isEmpty()?"YES\n":"NO\n");
        }
        System.out.println(sb);
    }
}
