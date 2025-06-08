package graph;

import java.io.*;

public class Baek_5639 {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int value;
        Node parent, left, right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Node root = null;

        while((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);

            if (root == null) {
                root = new Node(num);
                continue;
            }
            addNode(root, num);
        }

        postorderSearch(root);
        System.out.println(sb);
    }

    private static void addNode(Node current, int value){
        int curVal = current.value;
        if(curVal < value){
            if(current.right == null) {
                current.right = new Node(value);
            }else{
                addNode(current.right, value);
            }
        }else{
            if(current.left == null) {
                current.left = new Node(value);
            }else{
                addNode(current.left, value);
            }
        }
    }

    private static void postorderSearch(Node current){
        if(current.left !=null){
            postorderSearch(current.left);
        }

        if(current.right !=null){
            postorderSearch(current.right);
        }
        sb.append(current.value).append("\n");
    }
}
