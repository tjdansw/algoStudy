package stack;

import java.util.*;
import java.io.*;

// 4949
public class Baek_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while (!(line = br.readLine()).equals(".")){
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < line.length()&&isBalanced; i++) {
                char c = line.charAt(i);
                if(isOpenParentheses(c)){
                    stack.add(c);
                }else if(isCloseParentheses(c)){
                    if(stack.isEmpty()){
                        isBalanced = false;
                    }else{
                        char prev = stack.pop();
                        if(!isBalanceParentheses(prev, c)){
                            isBalanced = false;
                        }
                    }
                }
            }
            answer.append((isBalanced&&stack.isEmpty())?"yes\n":"no\n");
        }
        System.out.println(answer);
    }

    static boolean isOpenParentheses(char c){
        return c=='('||c=='[';
    }
    static boolean isCloseParentheses(char c){
        return c==')'||c==']';
    }

    static boolean isBalanceParentheses(char a, char b){
        return (a=='('&&b==')')||(a=='['&&b==']');
    }
}
