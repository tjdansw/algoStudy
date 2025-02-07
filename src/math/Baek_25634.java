package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_25634 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, value, current=0, min = 50001,max = 0, total=0;
    static boolean status;
    static int[] subSums;
    static int[] bulbs;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_25634.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bulbs = new int[n+1];
        subSums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            bulbs[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, bulbs[i]);
        }
        st = new StringTokenizer(br.readLine());
        boolean flag = true;
        for (int i = 1; i <= n; i++){
            status = st.nextToken().equals("1");
            if(status){
                total+=bulbs[i];
            }else {
                flag = false;
            }
            value = bulbs[i]*(status?-1:+1);
            current = Math.max(0,current+value);
            max = Math.max(max,current);
        }
        System.out.println(total+(flag?-min:max));
    }
}
