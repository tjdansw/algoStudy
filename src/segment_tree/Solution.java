package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t, n, m, start, size;
    static int[] mins, maxs;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            size = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
            mins = new int[size];
            maxs = new int[size];
            Arrays.fill(maxs, 0);
            Arrays.fill(mins, Integer.MAX_VALUE);

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                mins[size/2+i] = Integer.parseInt(st.nextToken());
                maxs[size/2+i] = mins[size/2+i];
            }

            start = size/2+n-(n%2==1?0:1);
            for(int i = start; i > 1; i-=2) {
                mins[i/2] = Math.min(mins[i-1], mins[i]);
                maxs[i/2] = Math.max(maxs[i-1], maxs[i]);
            }

            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                if(order == 0) {
                    int idx = Integer.parseInt(st.nextToken()) + size / 2;
                    int newValue = Integer.parseInt(st.nextToken());
                    mins[idx] = newValue;
                    maxs[idx] = newValue;
                    idx /= 2;
                    while(idx > 0) {
                        mins[idx] = Math.min(mins[2 * idx], mins[2 * idx + 1]);
                        maxs[idx] = Math.max(maxs[2 * idx], maxs[2 * idx + 1]);
                        idx /= 2;
                    }
                }else{
                    int l = Integer.parseInt(st.nextToken())+size/2;
                    int r = Integer.parseInt(st.nextToken())+size/2-1;

                    long min = Long.MAX_VALUE;
                    long max = Long.MIN_VALUE;

                    while(l<=r){
                        if(l%2==1){
                            min = Math.min(min, mins[l]);
                            max = Math.max(max, maxs[l]);
                        }
                        if(r%2==0){
                            min = Math.min(min, mins[r]);
                            max = Math.max(max, maxs[r]);
                        }

                        l = (l+1)/2;
                        r = (r-1)/2;
                    }
                    sb.append(max-min).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
