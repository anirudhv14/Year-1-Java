package trees;

public class CBT 
{
	int tree[],size,root;
	
	public CBT(int s)
	{
		size=root=0;
		tree=new int[s];
	}
	
	public void append(int e)
	{
		if(size<tree.length)
			tree[size++]=e;
		else
			System.err.println("ArrayIndexOutOfBoundsException!!");
	}
	
	private int left_r(int n)
	{
		int k=2*n+1;
		if(k<size)
			return k;
		else
		{
			System.err.println("NullPointerException");
			return -1;
		}
	}
	
	public int left(int n)
	{
		int f=0,k=0;
		for(int i=0;i<size;i++)
		{
			if(tree[i]==n)
			{
				f=1;
				k=left_r(i);
			}
		}
		if(f==0||k==-1)
		{
			return -1;
		}
		else
			return tree[k];
	}
	
	private int left_traversal(int n)
	{
		return n*2+1;
	}
	
	private int right_r(int n)
	{
		int k=2*n+2;
		if(k<size)
			return k;
		else
		{
			System.err.println("NullPointerException");
			return -1;
		}
	}
	
	public int right(int n)
	{
		int f=0,k=0;
		for(int i=0;i<size;i++)
		{
			if(tree[i]==n)
			{
				f=1;
				k=right_r(i);
			}
		}
		if(f==0||k==-1)
		{
			return -1;
		}
		else
			return tree[k];
	}
	
	private int right_traversal(int n)
	{
		return n*2+2;
	}
	
	
	private int parent_r(int n)
	{
		if(n!=0)
			return (n-1)/2;
		else
			return -1;
	}
	
	public int parent(int n)
	{
		int f=0,k=0;
		for(int i=0;i<size;i++)
		{
			if(tree[i]==n)
			{
				f=1;
				k=parent_r(i);
			}
		}
		if(f==0)
		{
			System.err.println("Element not found!!!");
			return -1;
		}
		else if(k==-1)
		{
			System.err.println("Parent of root cannot be found!!!");
			return -1;
		}
		else
			return tree[k];
	}
	
	public void delete(int n)
	{
		if(n<size)
		{
			for(int i=n;i<size-1;i++)
			{
				tree[i]=tree[i+1];
			}
			tree[size-1]=0;
			size--;
		}
		else
			System.err.println("NullPointerException!!");
	}
	
	private void inorder_rec(int k)
	{
		if(k>=size)
			return;
		else
		{
			inorder_rec(left_traversal(k));
			System.out.print(tree[k]+" ");
			inorder_rec(right_traversal(k));
		}
		
	}
	
	public void inorder()
	{
		inorder_rec(root);
		System.out.println();
	}
	
	private void preorder_rec(int k)
	{
		if(k>=size)
			return;
		else
		{
			System.out.print(tree[k]+" ");
			preorder_rec(left_traversal(k));
			preorder_rec(right_traversal(k));
		}
	}
	
	public void preorder()
	{
		preorder_rec(root);
		System.out.println();
	}
	
	private void postorder_rec(int k)
	{
		if(k>=size)
			return;
		else
		{
			postorder_rec(left_traversal(k));
			postorder_rec(right_traversal(k));
			System.out.print(tree[k]+" ");
		}
	}
	
	public void postorder()
	{
		postorder_rec(root);
		System.out.println();
	}
	
	public static void main(String args[])
	{
		CBT o=new CBT(10);
		o.append(1);
		o.append(2);
		o.append(3);
		o.append(4);
		o.append(5);
		o.append(6);
		o.append(7);
		o.append(8);
		for(int i=0;i<o.size;i++)
			System.out.print(o.tree[i]+" ");
		System.out.println();
		System.out.println(o.parent(5));
		System.out.println(o.right(2));
		System.out.println();
		for(int i=0;i<o.size;i++)
			System.out.print(o.tree[i]+" ");
		System.out.println();
		System.out.println(o.left(4));
		System.out.println("Inorder travesal");
		o.inorder();
		System.out.println("Preorder travesal");
		o.preorder();
		System.out.println("Postorder travesal");
		o.postorder();
		System.out.println();
		System.out.println(o.parent(8));
		o.delete(6);
		o.inorder();
		System.out.println(o.left(2));
	}
}
