package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baek_1991 {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n, root, l, r;
    static String line;
    static Node[] list = new Node[26];
    static class Node{
        char value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = (char)value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1991.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < 26; i++) list[i] = new Node(i+'A');
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            root = line.charAt(0) - 'A';
            l = line.charAt(2) - 'A';
            r = line.charAt(4) - 'A';
            if(l>=0) list[root].left = list[l];
            if(r>=0) list[root].right = list[r];
        }
        preorder(list[0]);
        sb.append('\n');
        inorder(list[0]);
        sb.append('\n');
        postorder(list[0]);
        sb.append('\n');
        System.out.println(sb);
    }

    // 전위 수행 Root → Left → Right
    static void preorder(Node root) {
        sb.append(root.value);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }
    
    // 중위 수행 Left → Root → Right
    static void inorder(Node root) {
        if(root.left != null) inorder(root.left);
        sb.append(root.value);
        if(root.right != null) inorder(root.right);
    }
    
    // 후위 수행 Left → Right → Root
    static void postorder(Node root) {
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        sb.append(root.value);
    }
}
