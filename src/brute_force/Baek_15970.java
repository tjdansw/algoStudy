package brute_force;

import java.util.*;
import java.io.*;

// 15970
public class Baek_15970 {
    static int n;
    static HashMap<Integer, ArrayList<Integer>> pointsInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = pointsInfo.getOrDefault(y, new ArrayList<>());
            list.add(x);
            pointsInfo.put(y, list);
        }

        long ans = 0;
        for(ArrayList<Integer> list:pointsInfo.values()){
            Collections.sort(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int len = 100_001;
                if(i>0){
                    len = Math.min(len, list.get(i)-list.get(i-1));
                }
                if(i<size-1){
                    len = Math.min(len, list.get(i+1)-list.get(i));
                }
                ans += len;
            }
        }
        System.out.println(ans);
    }
}
