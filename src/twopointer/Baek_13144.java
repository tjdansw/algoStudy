package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_13144 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static long cnt=0;
    static int[] nums;
    static boolean [] isContained = new boolean[100_001];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int end = 1;
        for(int start = 1; start <= n; start++) {
            while(end<=n){
                if(isContained[nums[end]]){
                    break;
                }
                isContained[nums[end]]=true;
                end++;
            }
            cnt+= end-start;
            isContained[nums[start]]=false;
        }

        System.out.println(cnt);
    }
}
