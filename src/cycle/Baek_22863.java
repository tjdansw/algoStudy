package cycle;

import java.util.*;
import java.io.*;

// 22863
public class Baek_22863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[] s = new int[n+1];
        int[] d = new int[n+1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st1.nextToken());
        }

        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            ArrayList<Integer> list = new ArrayList<>();
            int cur = i;
            while(!visited[cur]){
                visited[cur] = true;
                list.add(cur);
                cur = d[cur];
            }
            int size = list.size();
            for(int j = 0; j < size; j++){
                int from = list.get(j);
                int idx = (int)((j+k)%size);
                int to = list.get(idx);
                result[to] = s[from];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
