package sliding_window;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_20437 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int t,k,len,idx, cnt,min,max;
    static String w;
    static ArrayList<Integer>[] list = new ArrayList[26];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            reset();
            w = br.readLine();
            k = Integer.parseInt(br.readLine());
            len = w.length();
            for(int i = 0; i < len; i++) {
                idx = w.charAt(i) - 'a';
                list[idx].add(i);
                cnt = list[idx].size();
                if(cnt >= k) {
                    int value = list[idx].get(cnt-1)-list[idx].get(cnt-k)+1;
                    min = Math.min(min, value);
                    max = Math.max(max,value);
                }
            }
            if(max!=-1){
                sb.append(min).append(' ').append(max).append('\n');
            }else{
                sb.append("-1\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void reset(){
        min = 10000;
        max = -1;
        for(int i = 0; i < 26; i++){
            list[i] = new ArrayList<>();
        }
    }
}
