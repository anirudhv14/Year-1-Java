package satckAndQueues;

import java.util.*;
public class stackPostfixComputation extends stackArray 
{

	public stackPostfixComputation(int size) {
		super(size);
	}

	public static void main(String args[])
	{
		System.out.println("Enter the expression:");
		Scanner sc=new Scanner(System.in);
		stackArray o=new stackArray(4);
		String s=sc.nextLine();
		int kw=0,f=0;
		for(int i=0;i<s.length();i++)
		{
			char a=s.charAt(i);
			if(kw>2)
			{
				f=1;
				break;
			}
			if((int)a>=48&&(int)a<=57)
			{
				int w=(int)a;
				o.push(w-48);
				kw++;
			}
			else
			{
				int w1=o.pop();
				int w2=o.pop();
				switch(a)
				{
				case '+':o.push(w1+w2);
				break;
				case '-':o.push(w2-w1);
				break;
				case '*':o.push(w1*w2);
				break;
				case '/':o.push(w2/w1);
				break;
				}
				kw=0;
			}
		}
		if(f==1)
			System.out.println("Given expression is wrong!!");
		else
			o.print();
		sc.close();
	}
}