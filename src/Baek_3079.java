import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_3079 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static long m, left=1, right;;
    static int[] times;
    static long result=Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_3079.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        right= Long.MAX_VALUE;

        while(left<=right){
            long mid = (left+right+1)/2;
            long total = totalNum(mid);
            if(total>=m){
                result=Math.min(result,mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(result);
    }

    static long totalNum(long flag){
        long total = 0;
        for(int i = 0;i<n;i++) total += flag/times[i];
        return total;
    }
}
