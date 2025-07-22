package dynamic_programming;

import java.util.*;
import java.io.*;

// 1351
public class Baek_1351 {
    static HashMap<Long,Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp.put(0l,1l);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        System.out.println(solve(n,p,q));
    }

    private static Long solve(long n, long p, long q){
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        long res = 0;
        long next = n/p;
        if(dp.containsKey(next)){
            res+=dp.get(next);
        }else{
            long value = solve(next,p,q);
            dp.put(next,value);
            res += value;
        }
        next = n/q;
        if(dp.containsKey(next)){
            res+=dp.get(next);
        }else{
            long value = solve(next,p,q);
            dp.put(next,value);
            res += value;
        }
        dp.put(n,res);
        return res;
    }
}
