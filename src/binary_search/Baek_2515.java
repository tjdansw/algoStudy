package binary_search;

import java.util.*;
import java.io.*;

// 2515
public class Baek_2515 {
    static int n, s;
    static PictureInfo[] pictureInfos;
    static int[] dp;

    static class PictureInfo{
        int height, value;

        public PictureInfo(int height, int value) {
            this.height = height;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        pictureInfos = new PictureInfo[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pictureInfos[i] = new PictureInfo(height, value);
        }

        Arrays.sort(pictureInfos, (a,b)->{
            if(a.height==b.height) return Integer.compare(b.value, a.value);
            return Integer.compare(a.height, b.height);
        });

        dp[0] = pictureInfos[0].value;

        for(int i = 1;i<n;i++){
            int maxHeight = findMaxHeight(i);
            if(maxHeight>=0){
                dp[i] = Math.max(dp[maxHeight]+pictureInfos[i].value, dp[i-1]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], pictureInfos[i].value);
        }
        System.out.println(dp[n-1]);
    }

    static int findMaxHeight(int idx){
        int mid=0;
        int left = 0;
        int right = idx;

        while (left <= right){
            mid = (left+right)/2;
            int term = pictureInfos[idx].height - pictureInfos[mid].height;
            if(term>=s){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return right;
    }
}
