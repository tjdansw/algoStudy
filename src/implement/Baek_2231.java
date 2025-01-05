package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2231 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,result;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = n;i>0;i--){
            if(i+solve(i)==n){
                result = i;
            }
        }

        System.out.println(result);
    }

    static int solve(int num){
        int res = 0;
        while (num > 0){
            res+= num%10;
            num/=10;
        }
        return res;
    }
}
