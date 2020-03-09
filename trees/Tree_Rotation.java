package trees;
import data_structures.Tree;
public class Tree_Rotation extends Tree
{
	TNode root=null;
	private int getBalance(TNode n)
	{
		if(n!=null)
			return (getHeight(n.left)-getHeight(n.right));
		return 0;
	}
	
	private int getHeight(TNode n)
	{
		if(n!=null)
			return n.height;
		return 0;
	}
	
	private TNode rightRotate(TNode y)
	{
		TNode x=y.left;
		TNode T2=x.right;
		x.right=y;
		y.left=T2;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		return x;
	}
	
	private TNode leftRotate(TNode x)
	{
		TNode y = x.right;
		TNode T2 = y.left;

		// Rotation
		y.left = x;
		x.right = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}
	
	private TNode insert(TNode n,int data)
	{
		if (n == null) 
			return (new TNode(data));
		if (n.data > data) 
			n.left = insert(n.left, data);
		else 
			n.right = insert(n.right, data);
		n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
		int balDiff = getBalance(n);
		if (balDiff > 1 && data < n.left.data) 
			return rightRotate(n);
		if (balDiff < -1 && data > n.right.data) 
			return leftRotate(n);
		if (balDiff > 1 && data > n.left.data)
		{
			n.left = leftRotate(n.left);
			return rightRotate(n);
		}
		if (balDiff < -1 && data < n.right.data)
		{
			n.right = rightRotate(n.right);
			return leftRotate(n);
		}

		return n;
	}
	
	public void insert(int data)
	{
		root=insert(root,data);
	}
	
	private void inorder(TNode n)
	{
		if (n != null) 
		{
			inorder(n.left);
			System.out.print(" " + n.data);
			inorder(n.right);
		}
	}
	
	public void inorder()
	{
		inorder(root);
		System.out.println();
	}

	private void preorder(TNode r)
	{
		if(r!=null)
		{
			System.out.print(r.data+" ");
			preorder(r.left);
			preorder(r.right);
		}
	}

	public void preorder()
	{
		preorder(root);
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Tree_Rotation o=new Tree_Rotation();
		o.insert(4);
		o.insert(2);
		o.insert(1);
		o.insert(5);
		o.insert(6);
		o.insert(9);
		o.insert(14);
		o.insert(11);
		o.insert(10);
		o.insert(20);
		System.out.println("Inorder traversal of AVL Tree:");
		o.inorder();
		o.preorder();
		System.out.println("New root="+o.root.data);
		o.inorder();
		o.preorder();
	}
	
}