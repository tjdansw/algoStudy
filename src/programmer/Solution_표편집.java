package programmer;
import java.util.*;

class Solution_표편집 {
    class Node{
        int value;
        Node prev;
        Node next;
        boolean flag;
        
        Node(int value){
            this.value = value;
            flag = true;
            prev = null;
            next = null;
        }

		@Override
		public String toString() {
			return "Node [value=" + value + ", prev=" + (prev==null?"X":"O") + ", next=" + (next==null?"X":"O") + ", flag=" + flag + "]";
		}
    }
    Node currentNode;
    Node[] list;
    int size;
    Stack<Node> deleteList = new Stack<>();
    
    public String solution(int n, int k, String[] cmd) {
        list = new Node[n];
        size = n;
        list[0] = new Node(0);
        currentNode = list[0];
        for(int i = 1;i<n;i++){
            list[i] = new Node(i);
            list[i].prev = list[i-1];
            list[i-1].next = list[i];
            if(i==k){
                currentNode = list[i];
            }
        }
        for(String order : cmd){
            String[] split = order.split(" ");
            System.out.println(order);
            runCmd(split[0].charAt(0),(split.length==1?0:Integer.parseInt(split[1])));
            System.out.println(currentNode);
        }
        StringBuilder sb = new StringBuilder();
        for(Node node : list) {
        	sb.append(node.flag?"O":"X");
        }
        return sb.toString();
    }
    
    public void runCmd(char cmd,int num){
        switch(cmd){
            case 'D':{
                for(int i = 0;i<num;i++){
                    currentNode = currentNode.next;
                }
                break;
            }
            case 'U':{
                for(int i = 0;i<num;i++){
                    currentNode = currentNode.prev;
                }
                break;
            }
            case 'C':{
            	currentNode.flag = false;
                deleteList.add(currentNode);
                if(currentNode.prev!=null) {
                	currentNode.prev.next = currentNode.next;
                }
                if(currentNode.next!=null) {
                	currentNode.next.prev = currentNode.prev;
                	currentNode = currentNode.next; 
                }else {
                	currentNode = currentNode.prev;
                }
                break;
            }
            case 'Z':{
            	Node backUp = deleteList.pop();
            	backUp.flag = true;
            	if(backUp.next!=null) {
            		backUp.next.prev = backUp;
            	}
            	if(backUp.prev!=null) {
            		backUp.prev.next= backUp;
            	}
                break;
            }
        }
    }
    public static void main(String[] args) {
    	System.out.println(new Solution_표편집().solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
	}
}