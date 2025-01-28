package implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11866 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n ,k,total=0;
    static Node current;
    static Node[] list;
    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_11866.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new Node[n];
        list[0] = new Node(1);
        for (int i = 1; i < n; i++) {
            list[i] = new Node(i+1);
            list[i-1].next = list[i];
            list[i].prev = list[i-1];
        }
        list[0].prev = list[n-1];
        list[n-1].next = list[0];
        current = list[n-1];
        sb.append('<');
        while (total < n) {
            for(int i = 0;i<k;i++) current = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            sb.append(current.value).append(", ");
            total++;
        }
        sb.delete(sb.length()-2, sb.length()).append('>');
        System.out.println(sb);
    }
}
