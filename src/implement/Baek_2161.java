package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_2161 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Node current, end;
    static Node[] cards;

    static class Node {
        int num;
        Node next;
        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new Node[n];
        cards[0] = new Node(1);
        for (int i = 1; i < n; i++){
            cards[i] = new Node(i+1);
            cards[i-1].next = cards[i];
        }
        current = cards[0];
        end = cards[n-1];
        for(int i = 0;i<n;i++){
            try {
                end.next = current.next;
                sb.append(current.num).append(" ");
                end = end.next;
                current = current.next.next;
            }catch(Exception e){
                break;
            }
        }
        System.out.println(sb);
    }
}
