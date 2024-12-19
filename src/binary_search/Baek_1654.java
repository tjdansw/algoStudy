package binary_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1654 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int k, n;
    static long max=0, result=0;
    static int[] lineLen;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1654.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lineLen = new int[k];
        for (int i = 0; i < k; i++) {
            lineLen[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lineLen[i]);
        }

        solve(0,max);
        System.out.println(result);
    }

    static void solve(long left, long right){
        if(left >= right) return;
        long mid = (right + left+1)/2;
        int total = 0;
        for(int i = 0;i<k;i++) total += lineLen[i]/((int)mid);
        if(total >= n){
            result = Math.max(result, mid);
            solve(mid,right);
        }else{
            solve(left,mid-1);
        }
    }
}
