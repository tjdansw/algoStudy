package binary_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2343 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n ,m;
    static long left=0,right=1000000000, result = Long.MAX_VALUE;
    static int[] video;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2343.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        video = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            left = Math.max(video[i],left);
        }
        while(left<right){
            long mid = (left+right)/2;
            long total = 1;
            long temp = 0;
            boolean flag = false;
            for(int i =0;i<n;i++){
                temp+=video[i];
                if(temp>mid){
                    temp=video[i];
                    total++;
                }
                if(total>m) flag = true;
            }
            if(flag){
                left = mid+1;
                continue;
            }
            result = Math.min(mid,result);
            right = mid;
        }
        System.out.println(result);
    }
}
