package binary_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_12015 {
    static StringTokenizer st;
    static BufferedReader br;

    static int[] nums;
    static int n,num,len = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_12015.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=n;i++){
            num = Integer.parseInt(st.nextToken());
            if(nums[len]<num){
                len++;
                nums[len] = num;
            }else{
                binarySearch(1,len,num);
            }
        }
        System.out.println(len);
    }

    static void binarySearch(int start,int end, int value){
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]<value){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        nums[end] = value;
    }
}
