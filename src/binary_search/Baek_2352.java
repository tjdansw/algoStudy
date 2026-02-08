package binary_search;

import java.util.*;
import java.io.*;

// 2352
public class Baek_2352 {
    static int n, len = 0;
    static int[] portNums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        portNums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(portNums[len]<num){
                len++;
                portNums[len] = num;
            }else{
                binarySearch(1,len,num);
            }
        }
        System.out.println(len);
    }

    static void binarySearch(int start,int end, int value){
        while(start<end){
            int mid = (start+end)/2;
            if(portNums[mid]<value){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        portNums[end] = value;
    }
}
