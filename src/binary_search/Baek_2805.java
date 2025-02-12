package binary_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2805 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long m, left=0, right=0, result = 0;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2805.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while (left <= right){
            long mid = (left + right) / 2;
            if(possibleCase(mid)){
                result = Math.max(result,mid);
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    static boolean possibleCase(long flag){
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(trees[i]<=flag) continue;
            sum += trees[i]-flag;
            if(sum>=m) return true;
        }
        return false;
    }
}
