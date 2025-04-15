package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_14719 {
    static StringTokenizer st;
    static BufferedReader br;

    static int h, w, total=0;
    static int[] block;
    static Stack<Integer> stack = new Stack();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        block = new int[w];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int idx = 0;
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
            if(max < block[i]){
                max = block[i];
                idx = i;
            }
        }

        max = block[0];
        for(int i = 1; i <= idx; i++){
            if(block[i] >= max){
                while (!stack.isEmpty()){
                    total+=max-stack.pop();
                }
                max=block[i];
            }else{
                stack.add(block[i]);
            }
        }

        max = block[w-1];
        for(int i = w-1; i >= idx; i--){
            if(block[i] >= max){
                while (!stack.isEmpty()){
                    total+=max-stack.pop();
                }
                max=block[i];
            }else{
                stack.add(block[i]);
            }
        }

        System.out.println(total);
    }
}
