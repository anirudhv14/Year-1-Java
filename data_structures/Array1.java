
package data_structures;

public class Array1 implements Seq
{
	int arr[],size;
	final static int DEF_LENGTH =100;
	public Array1()
	{
		arr=new int[DEF_LENGTH ];
		size=0;
	}
	
	public Array1(int newsize)
	{
		arr=new int[newsize];
		size=0;
	}
	
	public void append(int i)
	{
		if(isEmpty())
			arr[0]=i;
		if(size!=arr.length)
			arr[size++]=i;
		else
		{
			int abc[]=new int[2*arr.length];
			for(int w=0;w<arr.length;w++)
			{
				abc[w]=arr[w];
			}
			arr=abc;
			arr[size++]=i;
		}
		
	}

	public void print() 
	{
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public void delete(int pos) 
	{
		for(int i=0;i<size-1;i++)
		{
			if(i>=pos-1)
				arr[i]=arr[i+1];
		}
		size--;
	}

	public void insert(int pos, int val) 
	{
		int temp[]=new int[size];
		for(int i=0;i<size;i++)
		{
			temp[i]=arr[i];
		}
		for(int i=0;i<=size;i++)
		{
			if(i==pos-1)
				arr[i]=val;
			else if(i>=pos-1)
				arr[i]=temp[i-1];
		}
		size++;
	}

	public int search(int val) 
	{
		int ctr=-1;
		for(int i=0;i<size;i++)
		{
			if(arr[i]==val)
			{
				ctr=i+1;
				break;
			}
		}
		return ctr;
	}

	public int ind(int ii)
	{
		return arr[ii];
	}
	
	public int lengthh()
	{
		return size;
	}
	
	public static void main(String args[])
	{
		Seq k=new Array1(5);
		System.out.println("Array:");
		for(int i=1;i<=10;i++)
			k.append(i);
		k.print();
		k.delete(3);
		k.print();
		k.insert(3, 3);
		k.print();
		System.out.println(k.search(3));
		
		System.out.println("List:");
		LinkedLIST k1=new LinkedLIST();
		for(int i=1;i<=10;i++)
		{
			k1.append(i);
		}
		k1.print();
		System.out.println(k1.search(9));
		k1.insert(4, 14);
		k1.print();
		System.out.println(k1.search(9));
		k1.delete(4);
		k1.print();
		System.out.println(k1.search(11));
	}	
}