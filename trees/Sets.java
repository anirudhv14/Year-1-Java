package trees;

import data_structures.Tree.TNode;

public interface Sets 
{
	public TNode insertion(int n,TNode k);
	public SetUsingTrees union(SetUsingTrees l);
	public void deletion(int k,TNode a);
	public void inOrder(TNode k);
}
