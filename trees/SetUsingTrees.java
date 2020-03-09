package trees;

import data_structures.Tree;

public class SetUsingTrees extends Tree implements Sets
{

	int ctr=0,arr[]=new int[100],za[]=new int[0];
	static TNode root1=null,root2=null,root3=null;
	
	public TNode insertion(int data,TNode k)
	{
		return insert_rec(data,k);
	}

	public SetUsingTrees union(SetUsingTrees l) 
	{
		SetUsingTrees t3=new SetUsingTrees() ;
		int a[]=trial(root1);
		for(int i=0;i<a.length;i++)
			t3.insertion(a[i], root3);
		int b[]=trial(root2);
		for(int i=0;i<b.length;i++)
			t3.insertion(b[i], root3);
		return t3;
	}
	
	private int[] trial(TNode r)
	{
		if(r!=null)
		{
			trial(r.left);
			trial(r.right);
			arr[ctr++]=r.data;
			return arr;
		}
		else
			return za;
	}

	public void deletion(int key,TNode r)
	{
		delete_rec(key,r);
	}
	
	public void inOrder(TNode l)
	{
		inorder_rec(l);
	}
	
	public static void main(String args[])
	{
		SetUsingTrees w=new SetUsingTrees();
		root1=w.insertion(4,root1);
		root1=w.insertion(5,root1);
		root1=w.insertion(5,root1);
		root1=w.insertion(5,root1);
		root1=w.insertion(1,root1);
		root1=w.insertion(2,root1);
		root1=w.insertion(8,root1);
		root1=w.insertion(0,root1);
		w.inOrder(root1);
		System.out.println();
		w.deletion(5,root1);
		w.inOrder(root1);
		System.out.println();
		SetUsingTrees x=new SetUsingTrees();
		root2=x.insertion(4,root2);
		root2=x.insertion(1,root2);
		root2=x.insertion(45,root2);
		root2=x.insertion(3,root2);
		root2=x.insertion(61,root2);
		root2=x.insertion(88,root2);
		System.out.println();
		x.inOrder(root2);
		System.out.println();
		SetUsingTrees z=x.union(w);
		z.inOrder(root3);
	}
}