package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_18870 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] coordinate, result;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_18870.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coordinate = new int[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            coordinate[i] = Integer.parseInt(st.nextToken());
            result[i] = coordinate[i];
        }
        Arrays.sort(result);
        map.put(result[0], 0);
        int value = 0;
        int plus = 1;
        for(int i = 1; i < n; i++){
            if(result[i-1]!=result[i]){
                value ++;
                map.put(result[i], value);
            }
        }
        for (int i = 0; i < n; i++) sb.append(map.get(coordinate[i])).append(" ");
        System.out.println(sb);
    }
}
