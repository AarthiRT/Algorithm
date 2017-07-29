import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
    Node insertNode(Node root, int parent, int child, String prop){
    	if(root == null)
    		return null;
    	if(root.data == parent){
    		if(prop.equalsIgnoreCase("L"))
    			root.left = new Node(child);
    		else if(prop.equalsIgnoreCase("R"))
    			root.right = new Node(child);
    		return root;
    	}
    	else{
    		Node temp = insertNode(root.left, parent, child, prop);
    		if(temp == null){
    			temp = insertNode(root.right, parent, child, prop);
    			if(temp == null)
    				return null;
    			else
    				root.right = temp;
    		}
    		else
    			root.left = temp;
    	}
    	return root;
    }
}
class MirrorNode {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        Node root = new Node(1);
        for (int i = 0; i < N-1; i++) {
            int p = s.nextInt();
            int c = s.nextInt();
            String prop = s.next();
            root = root.insertNode(root, p, c, prop);
        }
        for (int i = 0; i < Q; i++) {
        	int q = s.nextInt();
        	Node res = findMirrorNode(root,root,q);
        	if(res != null)
        		System.out.println(res.data);
        	else
        		System.out.println(-1);
        }
    }
   
    static Node findMirrorNode(Node left,Node right, int q){
    	if(left == null || right == null)
    		return null;
    	if(left.data == q)
    		return right;
    	else if(right.data == q)
    		return left;
    	Node temp = findMirrorNode(left.left, right.right, q);
    	if(temp != null)
    		return temp;
    	else
    		return findMirrorNode(left.right, right.left, q);
    }
}
