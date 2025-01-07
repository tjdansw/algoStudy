package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2609 {
    static StringTokenizer st;
    static BufferedReader br;

    static int[] nums = new int[2];
    static int a=1, b;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_2609.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        for(int i = 1;i<=nums[0];i++){
            a = (nums[0]%i==0&&nums[1]%i==0)?i:a;
        }
        b = nums[0];

        while(true){
            if(b%nums[1]==0){
                break;
            }
            b+=nums[0];
        }
        System.out.println(a+"\n"+b);
    }
}
