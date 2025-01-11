package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_2751 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb1 = new StringBuilder();

    static boolean[] negativeArr = new boolean[1000001];
    static boolean[] positiveArr = new boolean[1000001];
    static int n, num, min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            min = Math.min(min, num);
            max = Math.max(max, num);
            if(num<0){
                negativeArr[num*-1] = true;
            }else{
                positiveArr[num] = true;
            }
        }
        for(int i = min;i<=max;i++){
            if(i<0&&negativeArr[i*-1]){
                sb.append(i).append("\n");
            }else if(i>=0&&positiveArr[i]){
                sb1.append(i).append("\n");
            }
        }
        if(sb.length()>0){System.out.println(sb.deleteCharAt(sb.length()-1));}
        System.out.println(sb1);
    }
}
