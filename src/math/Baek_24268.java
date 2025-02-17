package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_24268 {
    static StringTokenizer st;
    static BufferedReader br;

    static long n;
    static int d;
    static int[] baseNum;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        baseNum=new int[d];
        dfs(d-1,new boolean[10]);
        System.out.println(-1);
    }

    static void dfs(int dept, boolean[] used){
        if(dept <0){
            if(baseNum[d-1]==0) return;
            long sum = 0;
            long value = 1;
            for(int i = 0; i < d; i++){
                sum += value*baseNum[i];
                value *= d;
            }
            if(sum > n){
                System.out.println(sum);
                System.exit(0);
            }
            return;
        }
        for(int i = 0; i <d ; i++){
            if(used[i]) continue;
            used[i] = true;
            baseNum[dept] = i;
            dfs(dept - 1, used);
            used[i] = false;
        }
    }
}
