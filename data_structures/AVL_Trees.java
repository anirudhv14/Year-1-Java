package data_structures;

public class AVL_Trees 
{
	public static void main(String args[])
	{
		//Tree o = new Tree();
		AVL_Trees o = new AVL_Trees();
		for(int i=1;i<=7;i++)
			o.insert(i);
		o.inorder();
	}
	
	
	public class TNode
	{
		//Node structure for BST
		TNode left,right;
		int data,height=0;
		public TNode(int d)
		{
			data=d;
			height=1;
			left=right=null;
		}

		public boolean isLeaf()
		{
			return(right==null && left==null);
		}
		
	};
	
	public static TNode root=null;
	
	public int height(TNode n)
	{
		if(n==null)
			return 0;
		else
			return n.height;
	}
	
	public int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	
	public boolean isEmpty()
	{
		return root==null;
	}
	
	//Height updating
	public int update(TNode a)
	{
		int h=1+max(height(a.left),height(a.right));
		return h;
	}
	
	public int getBalance(TNode x)
	{
		if(x==null)
			return 0;
		
		return height(x.left)-height(x.right);
	}
	
	//Right rotation
	public TNode rightRotate(TNode z)
	{
		TNode y = z.left;
		TNode T3 = y.right;
		
		z.left = T3;
		y.right = z;
		
		//Height updated after rotation
		z.height = update(z);
		y.height = update(y);
		
		return y;
	}
	
	//Left rotation
	public TNode leftRotate(TNode z)
	{
		TNode y = z.right;
		TNode T2 = y.left;
		
		z.right = T2;
		y.left = z;
		
		//Height updated after rotation
		z.height = update(z);
		y.height = update(y);
		
		return y;
	}
	
	//AVL Tree insertion
	public TNode insert_rec(int e,TNode r)
	{
		//return new node with data
		if(r==null)
			return new TNode(e);
		else
		{
			if(e<r.data)
				r.left=insert_rec(e,r.left);
			else if(e>r.data)
				r.right=insert_rec(e,r.right);
			else
				return r;
			
			
			r.height = update(r);
			
			// Check node balance...
			int bal = getBalance(r);
			
			//Left left case
			if(bal > 1  &&  e < r.left.data)
				return rightRotate(r);
			
			//Right right case 
			if(bal < -1 && e > r.right.data)
				return leftRotate(r);
			
			//Left right case
			if(bal > 1 && e > r.left.data)
			{
				r.left = leftRotate(r);
				return rightRotate(r);
			}
			
			//Right left case
			if(bal < -1 && e > r.right.data)
			{
				r.right = rightRotate(r);
				return leftRotate(r);
			}
				
				
			return r;
		}
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
	
	
	public void inorder_rec(TNode r)
	{
		if(r==null)
			System.out.print("-");
		if(r!=null)
		{
			System.out.print("(");
			inorder_rec(r.left);
			System.out.print(r.data+" ");
			inorder_rec(r.right);
			System.out.print(")");
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
