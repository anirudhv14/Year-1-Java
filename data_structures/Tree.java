package data_structures;

public class Tree 
{

	
	public static void main(String args[])
	{
		Tree o=new Tree();
//		o.insert(10);
//		o.insert(15);
//		o.insert(5);
//		o.insert(17);
//		o.insert(3);
//		o.insert(13);
//		o.insert(7);
//		o.insert(2);
//		o.insert(6);
//		o.insert(8);
//		o.insert(12);
//		o.insert(14);
//		o.insert(18);
//		o.inorder();
//		System.out.println();
//		o.preorder();
//		System.out.println();
//		o.postorder();
//		System.out.println();
//		o.inorder();
//		o.delete(10);
//		o.delete(18);
//		o.delete(6);
//		o.delete(5);
//		o.inorder();
		o.insert(5);
		o.insert(3);
		o.insert(7);
		o.insert(2);
		o.insert(4);
		o.insert(6);
		o.insert(8);
		o.inorder();
		o.preorder();
		o.postorder();
	}
	
	
	public class TNode
	{
		public TNode left;
		public TNode right;
		public int data;
		public int height;
		public TNode(int d)
		{
			data=d;
			height=1;
			left=null;
			right=null;
		}

		public boolean isLeaf()
		{
			return(right==null && left==null);
		}
	};
	
	public static TNode root=null;
	
	public boolean isEmpty()
	{
		return root==null;
	}
	
	public void insert(int e)
	{
		root=insert_rec(e,root);
	}
	

	public void inorder()
	{
		inorder_rec(root);
		System.out.println();
	}
	
	public void preorder()
	{
		preorder_rec(root);
		System.out.println();
	}
	
	public void postorder()
	{
		postorder_rec(root);
		System.out.println();
	}
	
	public void delete(int key)
	{
		root=delete_rec(key,root);
	}
	
	private int minRvalue(TNode r)
	{
		while(r.left!=null)
			r=r.left;
		return r.data;
	}
	
	public TNode delete_rec(int key,TNode r)
	{
		if(r==null)
			return r;
		else
		{
			if(key<r.data)
				r.left=delete_rec(key,r.left);
			else if(key>r.data)
				r.right=delete_rec(key,r.right);
			else
			{
				if(r.left==null)
					return r.right;
				else if(r.right==null)
					return r.left;
				r.data=minRvalue(r.right);
				r.right=delete_rec(r.data,r.right);
			}
			return r;
		}
	}
	
	public TNode insert_rec(int e,TNode r)
	{
		if(r==null)
			r=new TNode(e);
		else
		{
			if(e<r.data)
				r.left=insert_rec(e,r.left);
			else if(e>r.data)
				r.right=insert_rec(e,r.right);
		}
		return r;
	}
	
	public void inorder_rec(TNode r)
	{
//		if(r==null)
//			System.out.print(".");
		if(r!=null)
		{
			inorder_rec(r.left);
			System.out.print(r.data+" ");
			inorder_rec(r.right);
		}
	}
	
	private void preorder_rec(TNode r)
	{
//		if(r==null)
//			System.out.print(".");
		if(r!=null)
		{
			System.out.print(r.data+" ");
			preorder_rec(r.left);
			preorder_rec(r.right);
		}
	}
	
	private void postorder_rec(TNode r)
	{
//		if(r==null)
//			System.out.print("");
		if(r!=null)
		{
			postorder_rec(r.left);
			postorder_rec(r.right);
			System.out.print(r.data+" ");
			
		}
	}

}