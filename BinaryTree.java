
public class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
		
	}
	
	public void add(int value) {
		
	
		Node n = new Node(value);
		//case for list being empty
		if (root == null) {
			root = n;
			return;
		}
		Node current = root;
		//normal add
		
	
		while (true) {
			if(current.data == value) {
				current.counter++;
				return;
			}
			else if (n.data < current.data) {
				if(current.left == null) {
					current.left = n;
					return;
				}
				current = current.left;
			}
			else {
				if(current.right == null) {
					current.right = n;
					return;
				}
				current = current.right;
			}//end else
		}//end while
		
	}
	public void print() {
		print(root);
	}
	public void print(Node n) {
		if(n == null) return;
		print(n.left);
		
		for (int i = 0; i < n.counter; i++) {
		System.out.print(n.data);
		}
		print(n.right);
	}
	
	
	public void remove(int data) {
		Node n = Find(data);
		if (n == null) return;
		if(n.counter > 0) n.counter--;
	}
	public Node Find(int search) {
			return Find(root,search);
			
	}
	public Node Find(Node n, int search) {
		if (n == null) return null;
		if (n.data == search) return n;
		if (search < n.data) {
			return Find(n.left,search);
		}
		else {
			return Find(n.right,search);
		}
	}
	public int findMin() {
		int min = findMin(root, Integer.MAX_VALUE);
		if(min == Integer.MAX_VALUE) return 0;
		return min;
	}
	public int findMin(Node n, int smol) {
		if (n == null) return smol;
		if (n.data < smol && n.counter > 0) smol = n.data;
		
		int L = findMin(n.left,smol);
		int R = findMin(n.right,smol);
		
				return Math.min(L, R);
	}
	
	public int findMax() {
		int max = findMin(root, Integer.MIN_VALUE);
		if(max == Integer.MIN_VALUE) return 0;
		return max;
	}
	public int findMax(Node n, int big) {
		if (n == null) return big;
		if (n.data > big && n.counter > 0) big = n.data;
		
		int L = findMax(n.left,big);
		int R = findMax(n.right,big);
		
				return Math.max(L, R);
	}
	
}
