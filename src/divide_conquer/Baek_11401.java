package divide_conquer;

import java.util.*;
import java.io.*;

// 11401
public class Baek_11401 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k==0||n==k){
            System.out.println(1);
            return;
        }
        long a = factorial(n);
        long b = (factorial(n-k)*factorial(k))%MOD;
        b = pow(b,MOD-2);
        System.out.println((a*b)%MOD);
    }

    private static long factorial(int n){
        long res = 1;
        for(int i=2;i<=n;i++){
            res = (res*i)%MOD;
        }
        return res;
    }

    private static long pow(long x, int p){
        if(p==1){
            return x;
        }
        long half = pow(x,p/2);
        long result = (half*half)%MOD;
        if(p%2==1){
            result = (result*x)%MOD;
        }
        return result;
    }
}
