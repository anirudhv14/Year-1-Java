package coronavirus_project;
import coronavirus_project.Array;

public class HashList
{
	class Data
	{
		String key;
		String value;
		String v1,v2,v3;
		
		public Data(String k,String v,String v1, String v2, String v3)
		{
			key = k;
			value = v;
			this.v1 = v1;
			this.v2 = v2;
			this.v3 =v3;
		}
		
		public boolean equals(Data that)
		{
			return (this.key==that.key);
		}
		
		public int hashCode()
		{
			return key.hashCode();
		}
	};
	
	class Node
	{
		Data data;
		Node next,prev;
		
		public Node(Data d)
		{
			data = d;
			next = prev = null;
		}
	};
	
	Node map[];
	Array arr;
	int size;
	public HashList(int size)
	{
		map = new Node[size];
		arr = new Array();
		this.size = 0;
	}
	
	public boolean uniqueKey(String k)
	{
		int z = 0; 
		for(int i = 0; i < map.length;i++)
		{
			if(map[i] != null)
			{
				Node ptr = map[i];
				while(ptr != null)
				{
					if(ptr.data.key.equals(k))
						z = 1;
					ptr = ptr.next;
				}
			}
		}
		if(z == 0)
			return true;
		return false;
	}
	
	public boolean uniqueValue(String v)
	{
		int z = 0; 
		for(int i = 0; i < map.length;i++)
		{
			if(map[i] != null)
			{
				Node ptr = map[i];
				while(ptr != null)
				{
					if(ptr.data.value.equals(v))
						z = 1;
					ptr = ptr.next;
				}
			}
		}
		if(z == 0)
			return true;
		return false;
	}
	
	public int hash(Data n)
	{
		return n.hashCode() % map.length;
	}
	
	public void put(String k ,String v ,String v1 ,String v2 ,String v3)
	{
		Data d = new Data(k,v,v1,v2,v3);
		int h = java.lang.Math.abs(hash(d));
		Node n = new Node(d);

		if(uniqueKey(k))
		{
			size++;
			arr.append(k);
		}
		
		if(map[h] == null)
			map[h] = n;
		else
		{
			Node ptr = map[h];
			for(;ptr.next!=null;ptr = ptr.next);
			ptr.next = n;
			n.prev = ptr;
		}
	}
	

	public String get(String k)
	{
		int h = java.lang.Math.abs(k.hashCode() % map.length);
		
		Node ptr = map[h];
		while(ptr != null && !(ptr.data.key.equals(k)))
			ptr = ptr.next;
		return ((ptr == null)? null : ptr.data.value);		
	}
	
	public String[] retrieveAll(String k)
	{
		int h = java.lang.Math.abs(k.hashCode() % map.length);
		String vals[] = new String[3];
		int w1 = 0;
		int w2 = 0;
		int w3 = 0;
		Node ptr = map[h];
		while(ptr != null)
		{
			if( ptr.data.key.equals(k))
			{
				w1 += Double.parseDouble(ptr.data.v1);
				w2 += Double.parseDouble(ptr.data.v2);
				w3 += Double.parseDouble(ptr.data.v3);
			}
			ptr = ptr.next;
		}
		vals[0] = Integer.toString(w1);
		vals[1] = Integer.toString(w2);
		vals[2] = Integer.toString(w3);
		return vals;
	}
	
	public String[] getAll(String k)
	{
		int h = java.lang.Math.abs(k.hashCode() % map.length);
		String vals = "";
		Node ptr = map[h];
		while(ptr != null)
		{
			if( ptr.data.key.equals(k))
				vals=ptr.data.value+" "+vals;
			ptr = ptr.next;
		}
		return vals.trim().split(" ");		
	}
	
	public String[][] getAllDates(String k,int l)
	{
		int h = java.lang.Math.abs(k.hashCode() % map.length);
		String vals[][] = new String[4][l];
		int ctr = 0;
		Node ptr = map[h];
		while(ptr != null)
		{
			if( ptr.data.key.equals(k))
			{
				vals[0][ctr] = ptr.data.value;
				vals[1][ctr] = ptr.data.v1;
				vals[2][ctr] = ptr.data.v2;
				vals[3][ctr] = ptr.data.v3;
				ctr++;
			}
			ptr = ptr.next;
		}
		return vals;
	}
}