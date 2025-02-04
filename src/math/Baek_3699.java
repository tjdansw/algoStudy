package math;

import java.util.*;
import java.io.*;

public class Baek_3699 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb =  new StringBuilder();

    static int t, h, l, x, y, total;
    static ArrayList<int[]> list;
    static int[] hegith = new int[51];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/input/Baek_3699.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            h=Integer.parseInt(st.nextToken());
            l=Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i = 1 ; i <= h ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j <= l ; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==-1) continue;
                    list.add(new int[]{i,j,a});
                }
            }
            Collections.sort(list,(o1,o2)->Integer.compare(o1[2],o2[2]));
            x = 1;
            total = 0;
            Arrays.fill(hegith,1);
            for(int[] current: list){
                total += (current[0]-1)*10;
                int len = Math.abs(current[1]-hegith[current[0]]);
                hegith[current[0]] = current[1];
                total += Math.min(len,l-len)*5;
                total += (current[0]-1)*10;
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}