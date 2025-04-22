package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_7490 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t, n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_7490.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            solve(1, new char[n]);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void solve(int num, char[] operation) {
        if(num == n){
            check(operation);
            return;
        }
        operation[num] = ' ';
        solve(num + 1, operation);

        operation[num] = '+';
        solve(num + 1, operation);

        operation[num] = '-';
        solve(num + 1, operation);
    }

    public static void check(char[] operation) {
        int total = 0;
        int subSum = 0;
        int digit = 1;

        for(int i = 2*n; i > 1; i--){
            if(i%2==0){
                subSum += (i/2)*digit;
            }else{
                int idx = i/2;
                if(operation[idx] == '+'){
                    total += subSum;
                    subSum = 0;
                    digit = 1;
                }else if(operation[idx] == '-'){
                    total -= subSum;
                    subSum = 0;
                    digit = 1;
                }else{
                    digit*=10;
                }
            }
        }
        total+=subSum;
        if(total==0){
            for(int i = 1;i<n;i++){
                sb.append(i).append(operation[i]);
            }
            sb.append(n).append('\n');
        }
    }
}
