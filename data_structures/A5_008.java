package data_structures;

import java.io.*;

public class A5_008 extends LL_2
{
	public A5_008()
	{
	}
	public static void main(String args[])throws FileNotFoundException,IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\aniru\\Desktop\\Amrita\\Sem 2\\Data Structures & Algoritms\\Assignments\\logsamples.txt"));
		String nextLine=br.readLine();
		LL_2 k=new LL_2();
		while(nextLine!=null)
		{
			k.append(nextLine);			
			nextLine=br.readLine();
		}
		k.searchAndDisplay("Utils");
		String a[]=k.sortingTimeStamp();
		LL_2 lm=new LL_2();
		Node z=lm.start;
		int ctr=0;
		while(z!=null)
		{
			lm.append(a[ctr]);
			z=z.next;
			ctr++;
		}
		lm.print();
		br.close();
	}
}