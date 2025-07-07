package implement;

import java.util.*;
import java.io.*;

// 2108
public class Baek_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        double average = 0;
        int maxCnt = 0;
        ArrayList<Integer> modeList = new ArrayList<>();
        HashMap<Integer, Integer> numCnt = new HashMap<>();

        int num, temp;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            average += num;
            list.add(num);
            temp = numCnt.getOrDefault(num, 0)+1;
            numCnt.put(num, temp);
            if(maxCnt<=temp){
                if(maxCnt<temp){
                    modeList.clear();
                }
                maxCnt = temp;
                modeList.add(num);
            }
        }
        average /= n;

        Collections.sort(list);
        Collections.sort(modeList);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(average)).append("\n");
        sb.append(list.get(n/2)).append("\n");
        sb.append(modeList.get(modeList.size()==1?0:1)).append("\n");
        sb.append(list.get(list.size()-1)-list.get(0));
        System.out.println(sb);
    }
}
