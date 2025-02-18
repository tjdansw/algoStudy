package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_26260 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, num;
    static ArrayList<Integer> list = new ArrayList<>();
    static Node root;
    static class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_26260.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        int rootIdx = (n+1)/2;
        root = new Node(list.get(rootIdx));
        root.left = addNode(1,rootIdx-1);
        root.right = addNode(rootIdx+1,n);

        postorder(root);

        System.out.println(sb);
    }

    static void postorder(Node root) {
        if(root.left != null)
            postorder(root.left);
        if(root.right != null)
            postorder(root.right);
        sb.append(root.value).append(" ");
    }

    static Node addNode(int l, int r) {
        int mid = (l+r)/2;
        Node node = new Node(list.get(mid));
        if(l<mid){
            node.left = addNode(l,mid-1);
        }
        if(mid<r){
            node.right = addNode(mid+1,r);
        }
        return node;
    }
}
