import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTravTree {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static void printLevelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (true) {
			int size = queue.size(); // number of nodes at the current level
			if (size == 0)
				break;
			while (size > 0) { 	// for each level
				Node currNode = queue.poll();
				System.out.print(currNode.data + " ");
				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
				size--;
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		printLevelOrder(root);
	}
}
