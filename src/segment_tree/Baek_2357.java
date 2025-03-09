package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2357 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m,size;
    static int[] mins, maxs;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2,Math.ceil(Math.log(n)/Math.log(2)))*2;
        mins = new int[size];
        maxs = new int[size];
        Arrays.fill(mins,Integer.MAX_VALUE);
        Arrays.fill(maxs,Integer.MIN_VALUE);

        for(int i = 0; i < n; i++){
            mins[size/2+i] = Integer.parseInt(br.readLine());
            maxs[size/2+i] = mins[size/2+i];
        }

        for(int i = size/2+n-1; i > 1; i--){
            mins[i/2] = Math.min(mins[i/2], mins[i]);
            maxs[i/2] = Math.max(maxs[i/2], maxs[i]);
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken())+size/2 -1;
            int r = Integer.parseInt(st.nextToken())+size/2 -1;
            int min = 1_000_000_000;
            int max = 1;
            while(r>=l){
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
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
