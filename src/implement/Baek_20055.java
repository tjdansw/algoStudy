package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_20055 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, k, up, plus, step=0;
    static int[] down = new int[2];
    static int[] belt;
    static Robot head, tail;

    static class Robot{
        int position;
        Robot front,back;

        public Robot(int position) {
            this.position = position;
        }

        public Robot(int position, Robot front) {
            this.position = position;
            this.front = front;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_20055.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2*n];
        plus = 2*n-1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) belt[i] = Integer.parseInt(st.nextToken());

        while (k>0) {
            up = plus%(2*n);
            down[0] = (up+n-1)%(2*n);
            down[1] = (up+n)%(2*n);
            Robot now = head;

            while(now != null) {
                int nextPosition = (now.position+1)%(2*n);
                if(now == head && (now.position==down[0]||now.position==down[1])) {
                    head = now.back;
                }
                if((now.front==null||now.front.position!=nextPosition)&&belt[nextPosition] != 0){
                    belt[nextPosition]--;
                    if(belt[nextPosition]==0)k--;
                    now.position = nextPosition;
                }
                now = now.back;
            }

            if(belt[up]!=0){
                if(head == null){
                    head = new Robot(up);
                    tail = head;
                }else{
                    tail.back = new Robot(up,tail);
                    tail = tail.back;

                }
                belt[up]--;
                if(belt[up]==0) k--;
            }
            step++;
            plus = plus==0?2*n-1:plus-1;
        }

        System.out.println(step);
    }
}
