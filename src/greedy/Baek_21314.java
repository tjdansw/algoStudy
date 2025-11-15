package greedy;

import java.io.*;

// 21314
public class Baek_21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = word.length();
        StringBuilder maxValue = new StringBuilder();
        StringBuilder minValue = new StringBuilder();
        int mCnt = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(c=='M'){
               mCnt++;
            }else{
                maxValue.append(maxValue(mCnt));
                minValue.append(minValue(mCnt)).append(5);
                mCnt = 0;
            }
        }
        if(mCnt>0){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mCnt; i++) {
                sb.append(1);
            }
            maxValue.append(sb.toString());
            minValue.append(minValue(mCnt));
        }
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static String maxValue(int mCnt){
        StringBuilder sb = new StringBuilder();
        sb.append(5);
        for (int i = 0; i < mCnt; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    static String minValue(int mCnt){
        StringBuilder sb = new StringBuilder();
        if(mCnt==0) return "";
        sb.append(1);
        for (int i = 1; i < mCnt; i++) {
            sb.append(0);
        }
        return sb.toString();
    }
}
