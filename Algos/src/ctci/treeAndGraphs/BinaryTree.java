package ctci.treeAndGraphs;
//insertion allways in the left
public class BinaryTree {
	Node head;
	
	public BinaryTree(Node n){
		this.head=n;
	}
	public void createNode(Node root,int data){
		Node newNode=new Node(data);
		//temp=newNode;
		if(root==null){
			return;
		}else if(root.left==null){
			root.left=newNode;
		}else if(root.right==null){
			root.right=newNode;
		}else{
			createNode(root.left,data);
		}
		
		
	
	}
	
	public void  printTree(Node e){
		//preorder print
		if(e!=null){
			System.out.println(e.data);
		}
		if(e.left!=null){
			printTree(e.left);
		}
		if(e.right!=null){
			printTree(e.right);

		}
		
		
	}	

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(new Node(1));
		bt.createNode(bt.head, 2);
		bt.createNode(bt.head, 3);
		bt.createNode(bt.head, 4);
		bt.createNode(bt.head, 5);
		bt.createNode(bt.head, 6);
		bt.createNode(bt.head, 7);
		
	
		bt.printTree(bt.head);

	}
	
	
	
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data, Node left, Node right) {
			super();
			System.out.println("node inserted "+data);
			this.data = data;
			this.left = left;
			this.right = right;
		}
	   public Node(){
		   this(-1,null,null);
	   }
	   public Node(int d){
		   this(d,null,null);
	   }
	
	}

}
