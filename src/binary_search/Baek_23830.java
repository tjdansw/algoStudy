package binary_search;

import java.util.*;
import java.io.*;

// 23830
public class Baek_23830 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) scores[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        int left = 1, right = 200_000;
        int minK = 200_001;
        while(left<=right){
            int k =(left+right)/2;
            long totalScore = 0;

            for(int i = 0;i<n;i++){
                if(scores[i]>k+r){
                    totalScore += scores[i]-p;
                }else if(scores[i]<k){
                    totalScore += scores[i]+q;
                }else{
                    totalScore += scores[i];
                }
            }

            if(s<=totalScore){
                minK = Math.min(minK, k);
                right = k-1;
            }else{
                left = k+1;
            }
        }
        System.out.println(minK==200_001?-1:minK);
    }
}
