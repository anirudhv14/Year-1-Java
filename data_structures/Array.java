package data_structures;

public class Array
{
	int size=0,a[];
	public Array()
	{
		a=new int[10];
	}
	public Array(int n)
	{
		a=new int[n];
	}
	void append(int n)
	{
		if(size==a.length)
		{
			int temp[]=new int[2*a.length];
			for(int i=0;i<a.length;i++)
				temp[i]=a[i];
			a=temp;
		}
		a[size++]=n;
		
	}
	void  sort(int aod)
	{
		int temp=0;
		if(aod==1)
		{
			for( int i=0;i<size;i++)
			{
				for(int j=0;j<=size-i-1;j++)
				{
					if(a[j]>a[j+1])
					{
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
			}
		}
		else if(aod==0)
			for( int i=0;i<size;i++)
			{
				for(int j=0;j<=size-i-1;j++)
				{
					if(a[j]<a[j+1])
					{
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
			}
	}
	int search(int n)
	{
		int f=0,c=0;
		for(int i=0;i<size;i++)
		{
			if(a[i]==n)
			{
				f=1;
				c=i;
				break;
			}
		}
		if(f==1)
			return c;
		else
			return -1;
	}
	void insert(int pos,int val)
	{
		int k[]=new int[size+1];
		for(int i=0;i<pos;i++)
			k[i]=a[i];
		k[pos]=val;
		for(int i=pos+1;i<=size;i++)
			k[i]=a[i-1];
		a=k;
	}
	void delete(int pos)
	{
		int k[]=new int[size-1];
		for(int i=0;i<pos;i++)
			k[i]=a[i];
		for(int i=pos+1;i<size;i++)
			k[i-1]=a[i];
		a=k;
	}
	void print()
	{
		for(int i=0;i<=size;i++)
			System.out.println(a[i]);
	}
	public static void main(String args[])
	{
		Array o=new Array();
		for(int i=1;i<=10;i++)
		{
			o.append(i+1);
		}
		System.out.println();
		o.sort(0);
		System.out.println();
		o.insert(3,4);
		System.out.println();
		o.delete(3);
		System.out.println();
		o.print();
		int w=o.search(15);
		System.out.println();
		System.out.println("At position:"+w);
	}
}