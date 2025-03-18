package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_13414 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int k, l, idx=0, cnt;
    static String hakbun;
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for(int i = 0;i<l;i++){
            hakbun = br.readLine();
            map.put(hakbun,map.getOrDefault(hakbun,0)+1);
            list.add(hakbun);
        }

        while(idx<l&&k>0){
            hakbun = list.get(idx++);
            cnt = map.get(hakbun);
            if(cnt==1){
                sb.append(hakbun).append("\n");
                k--;
            }else{
                map.put(hakbun,cnt-1);
            }
        }
        System.out.println(sb);
    }
}
