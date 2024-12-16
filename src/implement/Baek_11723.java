package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11723 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int m;
    static int bitMask = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11723.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":{
                    int num = Integer.parseInt(st.nextToken());
                    addNum(num);
                    break;
                }
                case "remove":{
                    int num = Integer.parseInt(st.nextToken());
                    removeNum(num);
                    break;
                }
                case "check":{
                    int num = Integer.parseInt(st.nextToken());
                    sb.append(containsNum(num)).append('\n');
                    break;
                }
                case "toggle":{
                    int num = Integer.parseInt(st.nextToken());
                    toggleNum(num);
                    break;
                }
                case "all":{
                    all();
                    break;
                }
                case "empty":{
                    empty();
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    public static void addNum(int num) {
        bitMask |= (1 << num);
    }

    public static void removeNum(int num) {
        bitMask &= ~(1 << num);
    }

    public static int containsNum(int num) {
        return (bitMask & (1 << num)) != 0?1:0; // 해당 숫자 위치의 비트가 1인지 확인
    }

    public static void toggleNum(int num) {
        if (containsNum(num) == 1) {
            removeNum(num);
        } else {
            addNum(num);
        }
    }

    public static void all(){
        bitMask = (1 << 22) - 1;
    }

    public static void empty(){
        bitMask = 0;
    }
}
