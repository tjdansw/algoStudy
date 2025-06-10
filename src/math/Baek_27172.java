package math;

import java.io.*;
import java.util.StringTokenizer;

// 27172
public class Baek_27172 {
    static int n;
    static boolean[] isExisted = new boolean[1_000_001];
    static int[] nums = new int[1_000_001];
    static int[] score = new int[1_000_001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            isExisted[num] = true;
        }

        for(int i = 0;i<n;i++){
            int mod = nums[i];
            for(int num = mod*2;num<1_000_001;num+=mod){
                if(isExisted[num]){
                    score[mod]++;
                    score[num]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            sb.append(score[nums[i]]).append(' ');
        }
        System.out.println(sb);
    }
}
