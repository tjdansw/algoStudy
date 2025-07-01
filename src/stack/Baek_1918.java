package stack;

import java.util.*;
import java.io.*;

// 1918
public class Baek_1918 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c>='A' && c<='Z') {
                sb.append(c);
            }else{
                if(c=='('){
                    stack.push(c);
                }else if(c==')'){
                    while (!stack.isEmpty() && stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()){
                        stack.pop(); // ( 버림
                    }
                }else{
                    while (!stack.isEmpty() && operationOrder(stack.peek()) >= operationOrder(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int operationOrder(char c){
        if(c=='(') return 0;
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return -1;
    }
}
