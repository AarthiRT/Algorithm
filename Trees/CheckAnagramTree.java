import java.util.LinkedList;
import java.util.Queue;

public class CheckAnagramTree {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	public static boolean isAnagramTree(Node Tree1, Node Tree2){
		boolean flag= true;
		if(Tree1 == null && Tree2 == null)
			flag = true;
		else if(Tree1 == null || Tree2 == null)
			flag = false;
		else{
			Queue<Node> q1 = new LinkedList<Node>();
			Queue<Node> q2 = new LinkedList<Node>();
			q1.add(Tree1);
			q2.add(Tree2);
			while(true){
				if(q1.size() == 0 && q2.size() == 0)
					break;
				if(q1.size() != q2.size())
					return false;
				int size = q1.size();
				while(size > 0){
					Node currNode1 = q1.poll();
					Node currNode2 = q2.poll();
					if(currNode1.data != currNode2.data)
						return false;
					if(currNode1.left!=null)
						q1.add(currNode1.left);
					if(currNode2.left!=null)
						q2.add(currNode2.left);
					if(currNode1.right!=null)
						q1.add(currNode1.right);
					if(currNode2.right!=null)
						q2.add(currNode2.right);
					size--;
				}
			}
		}
		return flag;
	}
	public static void main(String args[]){
		Node tree1 = new Node(1);
		tree1.left = new Node(2);
		tree1.right = new Node(3);
		tree1.left.left = new Node(4);
		tree1.left.right = new Node(5);
		tree1.right.right = new Node(6);
		Node tree2 = new Node(1);
		tree2.right = new Node(2);
		tree2.left = new Node(3);
		tree2.right.right = new Node(4);
		tree2.right.left = new Node(5);
		tree2.left.left = new Node(6);
		System.out.println(isAnagramTree(tree1,tree2));
	}
}
